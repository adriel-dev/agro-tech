package br.com.agrotech.domain.animal.port.api.usecase.impl

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.animal.port.api.usecase.FindAllAnimals
import br.com.agrotech.domain.animal.port.spi.persistence.AnimalRepository

class FindAllAnimalsUseCase(
    private val animalRepository: AnimalRepository
) : FindAllAnimals {

    override fun findAllAnimals(): List<Animal> {
        return animalRepository.findAllAnimals()
    }

}