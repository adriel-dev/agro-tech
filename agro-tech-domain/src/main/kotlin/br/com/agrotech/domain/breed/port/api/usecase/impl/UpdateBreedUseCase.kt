package br.com.agrotech.domain.breed.port.api.usecase.impl

import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.domain.breed.port.api.usecase.UpdateBreed
import br.com.agrotech.domain.breed.port.spi.persistence.BreedRepository

class UpdateBreedUseCase(
    private val breedRepository: BreedRepository
) : UpdateBreed {

    override fun updateBreed(breedId: String, breed: Breed): Breed {
        return breedRepository.updateBreed(breedId, breed)
    }

}