package br.com.agrotech.domain.animal.port.api.usecase.impl

import br.com.agrotech.domain.animal.port.api.usecase.DeleteAnimalById
import br.com.agrotech.domain.animal.port.spi.persistence.AnimalRepository
import java.util.*

class DeleteAnimalByIdUseCase(
    private val animalRepository: AnimalRepository
) : DeleteAnimalById {

    override fun delete(animalId: UUID) {
        animalRepository.deleteAnimalById(animalId)
    }

}