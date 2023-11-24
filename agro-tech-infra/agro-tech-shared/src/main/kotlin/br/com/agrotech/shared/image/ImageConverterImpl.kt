package br.com.agrotech.shared.image

import br.com.agrotech.domain.image.model.Image
import br.com.agrotech.persistence.image.entity.ImageEntity
import br.com.agrotech.shared.animal.AnimalConverter
import br.com.agrotech.web.image.dto.ImageDTO
import org.springframework.stereotype.Component

@Component
class ImageConverterImpl(private val animalConverter: AnimalConverter) : ImageConverter {

    override fun imageEntityToImage(imageEntity: ImageEntity): Image {
        return Image(
            id = imageEntity.id,
            type = imageEntity.type,
            filePath = imageEntity.filePath,
            fileExtension = imageEntity.fileExtension,
            animal = imageEntity.animal?.let { animalConverter.animalEntityToAnimal(it) }
        )
    }

    override fun imageToImageEntity(image: Image): ImageEntity {
        return ImageEntity(
            id = image.id,
            type = image.type,
            filePath = image.filePath,
            fileExtension = image.fileExtension,
            animal = image.animal?.let { animalConverter.animalToAnimalEntity(it) }
        )
    }

    override fun imageDtoToImage(imageDTO: ImageDTO): Image {
        return Image(
            id = imageDTO.id,
            type = imageDTO.type,
            filePath = imageDTO.filePath,
            fileExtension = imageDTO.fileExtension,
            animal = imageDTO.animal?.let { animalConverter.animalDtoToAnimal(it) }
        )
    }

    override fun imageToImageDto(image: Image): ImageDTO {
        return ImageDTO(
            id = image.id,
            type = image.type,
            filePath = image.filePath,
            fileExtension = image.fileExtension,
            animal = image.animal?.let { animalConverter.animalToAnimalDto(it) }
        )
    }

}