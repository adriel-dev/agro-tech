package br.com.agrotech.web.image.converter

import br.com.agrotech.domain.image.model.Image
import br.com.agrotech.web.animal.converter.AnimalWebConverter
import br.com.agrotech.web.image.dto.ImageDTO
import org.springframework.stereotype.Component

@Component
class ImageWebConverter(
    private val animalConverter: AnimalWebConverter
) {

    fun imageDtoToImage(imageDTO: ImageDTO): Image {
        return Image(
            id = imageDTO.id,
            type = imageDTO.type,
            filePath = imageDTO.filePath,
            fileExtension = imageDTO.fileExtension,
            animal = imageDTO.animal?.let { animalConverter.animalDtoToAnimal(it) }
        )
    }

    fun imageToImageDto(image: Image): ImageDTO {
        return ImageDTO(
            id = image.id,
            type = image.type,
            filePath = image.filePath,
            fileExtension = image.fileExtension,
            animal = image.animal?.let { animalConverter.animalToAnimalDto(it) }
        )
    }

}