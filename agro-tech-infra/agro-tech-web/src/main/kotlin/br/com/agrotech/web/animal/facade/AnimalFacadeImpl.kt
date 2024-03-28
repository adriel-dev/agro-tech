package br.com.agrotech.web.animal.facade

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.animal.port.api.usecase.*
import br.com.agrotech.domain.image.model.Image
import br.com.agrotech.domain.pagination.DomainPage
import br.com.agrotech.persistence.user.entity.UserEntity
import br.com.agrotech.web.animal.converter.AnimalWebConverter
import br.com.agrotech.web.animal.dto.AnimalDTO
import br.com.agrotech.web.animal.dto.request.SaveAnimalRequestDTO
import br.com.agrotech.web.animal.dto.response.FindAllAnimalsResponseDTO
import br.com.agrotech.web.animal.dto.response.FindAnimalByIdResponseDTO
import br.com.agrotech.web.animal.dto.response.SaveAnimalResponseDTO
import br.com.agrotech.web.image.util.ImageUtils
import br.com.agrotech.web.image.exception.InvalidImageException
import br.com.agrotech.web.qrcode.dto.QrCodeDTO
import org.springframework.security.access.prepost.PostAuthorize
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.util.*

@Component
open class AnimalFacadeImpl(
    private val saveAnimal: SaveAnimal,
    private val findAnimalById: FindAnimalById,
    private val updateAnimal: UpdateAnimal,
    private val deleteAnimalById: DeleteAnimalById,
    private val findAllAnimals: FindAllAnimals,
    private val animalConverter: AnimalWebConverter,
    private val imageUtils: ImageUtils
) : AnimalFacade {

    @PreAuthorize("@animalPermissionEvaluator.hasPermissionToSave(authentication, #saveAnimalRequestDTO)")
    override fun saveAnimal(saveAnimalRequestDTO: SaveAnimalRequestDTO, imageFile: MultipartFile?): SaveAnimalResponseDTO {
        val animal = animalConverter.saveAnimalRequestDtoToAnimal(saveAnimalRequestDTO)
        var image: Image? = null
        var imageData: ByteArray? = null
        if(imageFile != null) {
            if(imageUtils.isImageFileValid(imageFile)) {
                image = Image(type = imageFile.contentType, fileExtension = imageUtils.getFileExtension(imageFile))
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

    override fun findAllAnimals(
        authentication: Authentication, page: Int, size: Int,
        speciesIds: List<UUID>?, animalName: String?, externalId: String?
    ): DomainPage<FindAllAnimalsResponseDTO> {
        val user = authentication.principal as UserEntity
        val farmId = user.farm?.id!!
        val domainPageAnimals = findAllAnimals.find(farmId, page, size, speciesIds, animalName, externalId)
        val responseDomainPageAnimals = domainPageAnimals.content.map { animalConverter.animalToFindAllAnimalsResponseDTO(it, "") }
        return DomainPage(responseDomainPageAnimals, domainPageAnimals.totalPages, domainPageAnimals.totalElements, domainPageAnimals.pageSize, domainPageAnimals.pageNumber)
    }

    @PreAuthorize("@animalPermissionEvaluator.hasPermissionToUpdateOrDelete(authentication, #animalId)")
    override fun updateAnimal(animalId: UUID, animalDto: AnimalDTO, imageFile: MultipartFile?): AnimalDTO {
        var imageBytes: ByteArray? = null
        var image: Image? = null
        imageFile?.let {
            if(imageUtils.isImageFileValid(it)){
                imageBytes = it.bytes
                image = Image(animal = Animal(id = animalId), type = it.contentType, fileExtension = imageUtils.getFileExtension(it))
            }
        }
        val animal = animalConverter.animalDtoToAnimal(animalDto)
        return animalConverter.animalToAnimalDto(updateAnimal.update(animalId = animalId, animal = animal, imageBytes = imageBytes, image))
    }

    @PreAuthorize("@animalPermissionEvaluator.hasPermissionToUpdateOrDelete(authentication, #animalId)")
    override fun deleteAnimalById(animalId: UUID) {
        deleteAnimalById.delete(animalId = animalId)
    }

}