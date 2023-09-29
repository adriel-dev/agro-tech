package br.com.agrotech.domain.animal.port.api.usecase.impl

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.animal.port.api.usecase.FindAnimalById
import br.com.agrotech.domain.animal.port.spi.persistence.AnimalRepository
import java.util.UUID

class FindAnimalByIdUseCase(
    private val animalRepository: AnimalRepository
) : FindAnimalById {

    override fun find(animalId: UUID): Animal {
        return animalRepository.findAnimalById(animalId)
    }

}