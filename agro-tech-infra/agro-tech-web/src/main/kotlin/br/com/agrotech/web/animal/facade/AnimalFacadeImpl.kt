package br.com.agrotech.web.animal.facade

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.animal.port.api.usecase.DeleteAnimalById
import br.com.agrotech.domain.animal.port.api.usecase.FindAnimalById
import br.com.agrotech.domain.animal.port.api.usecase.SaveAnimal
import br.com.agrotech.domain.animal.port.api.usecase.UpdateAnimal
import br.com.agrotech.domain.image.model.Image
import br.com.agrotech.web.animal.converter.AnimalWebConverter
import br.com.agrotech.web.animal.dto.AnimalDTO
import br.com.agrotech.web.animal.dto.request.SaveAnimalRequestDTO
import br.com.agrotech.web.animal.dto.response.FindAnimalByIdResponseDTO
import br.com.agrotech.web.animal.dto.response.SaveAnimalResponseDTO
import br.com.agrotech.web.image.exception.InvalidImageException
import br.com.agrotech.web.qrcode.dto.QrCodeDTO
import org.springframework.security.access.prepost.PostAuthorize
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.util.*

@Component
open class AnimalFacadeImpl(
    private val saveAnimal: SaveAnimal,
    private val findAnimalById: FindAnimalById,
    private val updateAnimal: UpdateAnimal,
    private val deleteAnimalById: DeleteAnimalById,
    private val animalConverter: AnimalWebConverter
) : AnimalFacade {

    @PreAuthorize("@animalPermissionEvaluator.hasPermissionToSave(authentication, #saveAnimalRequestDTO)")
    override fun saveAnimal(saveAnimalRequestDTO: SaveAnimalRequestDTO, imageFile: MultipartFile?): SaveAnimalResponseDTO {
        val animal = animalConverter.saveAnimalRequestDtoToAnimal(saveAnimalRequestDTO)
        var image: Image? = null
        var imageData: ByteArray? = null
        if(imageFile != null) {
            if(isImageFileValid(imageFile)) {
                image = Image(type = imageFile.contentType, fileExtension = getFileExtension(imageFile))
                imageData = imageFile.bytes
            } else {
                throw InvalidImageException()
            }
        }
        return animalConverter.animalToSaveAnimalResponseDto(saveAnimal.save(animal = animal, image = image, imageData = imageData))
    }

    @PostAuthorize("@animalPermissionEvaluator.hasPermissionToGet(authentication, returnObject)")
    override fun findAnimalById(animalId: UUID): FindAnimalByIdResponseDTO {
        val foundData = findAnimalById.find(animalId)
        val responseDto = animalConverter.animalToFindAnimalByIdResponseDto(foundData["animal"] as Animal)
        responseDto.image = foundData["imageData"] as ByteArray?
        responseDto.qrCode = foundData["qrCode"] as QrCodeDTO?
        return responseDto
    }

    @PreAuthorize("@animalPermissionEvaluator.hasPermissionToUpdateOrDelete(authentication, #animalId)")
    override fun updateAnimal(animalId: UUID, animalDto: AnimalDTO): AnimalDTO {
        val animal = animalConverter.animalDtoToAnimal(animalDto)
        return animalConverter.animalToAnimalDto(updateAnimal.update(animalId = animalId, animal = animal))
    }

    @PreAuthorize("@animalPermissionEvaluator.hasPermissionToUpdateOrDelete(authentication, #animalId)")
    override fun deleteAnimalById(animalId: UUID) {
        deleteAnimalById.delete(animalId = animalId)
    }

    private fun isImageFileValid(file: MultipartFile): Boolean {
        val allowedExtensions = listOf("jpg", "jpeg", "png")
        val fileExtension = getFileExtension(file)
        return file.contentType?.startsWith("image/") == true && allowedExtensions.contains(fileExtension?.lowercase())
    }

    private fun getFileExtension(file: MultipartFile): String? {
        return file.originalFilename?.substringAfterLast('.')
    }

}