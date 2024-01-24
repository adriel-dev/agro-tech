package br.com.agrotech.persistence.image.converter

import br.com.agrotech.domain.image.model.Image
import br.com.agrotech.persistence.animal.converter.AnimalPersistenceConverter
import br.com.agrotech.persistence.image.entity.ImageEntity
import org.springframework.stereotype.Component

@Component
class ImagePersistenceConverter(private val animalConverter: AnimalPersistenceConverter) {

    fun imageEntityToImage(imageEntity: ImageEntity): Image {
        return Image(
            id = imageEntity.id,
            type = imageEntity.type,
            filePath = imageEntity.filePath,
            fileExtension = imageEntity.fileExtension,
            animal = imageEntity.animal?.let { animalConverter.animalEntityToAnimal(it) }
        )
    }

    fun imageToImageEntity(image: Image): ImageEntity {
        return ImageEntity(
            id = image.id,
            type = image.type,
            filePath = image.filePath,
            fileExtension = image.fileExtension,
            animal = image.animal?.let { animalConverter.animalToAnimalEntity(it) }
        )
    }

}