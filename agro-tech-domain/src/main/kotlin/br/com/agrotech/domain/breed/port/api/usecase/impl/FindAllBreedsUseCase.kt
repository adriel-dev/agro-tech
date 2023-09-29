package br.com.agrotech.domain.breed.port.api.usecase.impl

import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.domain.breed.port.api.usecase.FindAllBreeds
import br.com.agrotech.domain.breed.port.spi.persistence.BreedRepository

class FindAllBreedsUseCase(
    private val breedRepository: BreedRepository
) : FindAllBreeds {

    override fun findAllBreeds(): List<Breed> {
        return breedRepository.findAllBreeds()
    }

}