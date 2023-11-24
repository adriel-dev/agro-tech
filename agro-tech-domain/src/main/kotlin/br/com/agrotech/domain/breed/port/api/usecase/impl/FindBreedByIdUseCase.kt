package br.com.agrotech.domain.breed.port.api.usecase.impl

import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.domain.breed.port.api.usecase.FindBreedById
import br.com.agrotech.domain.breed.port.spi.persistence.BreedRepository
import java.util.UUID

class FindBreedByIdUseCase(
    private val breedRepository: BreedRepository
) : FindBreedById {

    override fun find(breedId: UUID): Breed {
        return breedRepository.findBreedById(breedId)
    }

}