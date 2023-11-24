package br.com.agrotech.web.animal.impl

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.animal.port.api.usecase.SaveAnimal
import br.com.agrotech.domain.animal.port.spi.persistence.AnimalRepository
import br.com.agrotech.domain.image.model.Image
import br.com.agrotech.domain.image.port.api.usecase.SaveImage
import org.springframework.transaction.annotation.Transactional

open class SaveAnimalUseCase(
    private val animalRepository: AnimalRepository,
    private val saveImage: SaveImage
) : SaveAnimal {

    @Transactional
    override fun save(animal: Animal, image: Image?, imageData: ByteArray?): Animal {
        val savedAnimal = animalRepository.saveAnimal(animal)
        if(image != null && imageData != null) {
            image.animal = savedAnimal
            saveImage.save(image = image, imageData = imageData)
        }
        return savedAnimal
    }

}