package br.com.agrotech.domain.animal.port.api.usecase.impl

import br.com.agrotech.domain.animal.port.api.usecase.UpdateAnimal
import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.animal.port.spi.persistence.AnimalRepository
import java.util.*

class UpdateAnimalUseCase(
    private val animalRepository: AnimalRepository
) : UpdateAnimal {

    override fun update(animalId: UUID, animal: Animal): Animal {
        return animalRepository.updateAnimal(animalId, animal)
    }

}