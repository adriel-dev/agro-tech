package br.com.agrotech.domain.breed.port.api.usecase.impl

import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.domain.breed.port.api.usecase.FindBreedById
import br.com.agrotech.domain.breed.port.spi.persistence.BreedRepository

class FindBreedByIdUseCase(
    private val breedRepository: BreedRepository
) : FindBreedById {

    override fun findBreedById(breedId: String): Breed {
        return breedRepository.findBreedById(breedId)
    }

}