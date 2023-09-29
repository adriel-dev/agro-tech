package br.com.agrotech.domain.animal.port.api.usecase.impl

import br.com.agrotech.domain.animal.port.api.usecase.SaveAnimal
import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.animal.port.spi.persistence.AnimalRepository

class SaveAnimalUseCase(
    private val animalRepository: AnimalRepository
) : SaveAnimal {

    override fun save(animal: Animal): Animal {
        return animalRepository.saveAnimal(animal)
    }

}