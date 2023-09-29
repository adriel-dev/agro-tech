package br.com.agrotech.domain.breed.port.api.usecase.impl

import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.domain.breed.port.api.usecase.SaveBreed
import br.com.agrotech.domain.breed.port.spi.persistence.BreedRepository

class SaveBreedUseCase(
    private val breedRepository: BreedRepository
) : SaveBreed {

    override fun saveBreed(breed: Breed): Breed {
        return breedRepository.saveBreed(breed)
    }

}