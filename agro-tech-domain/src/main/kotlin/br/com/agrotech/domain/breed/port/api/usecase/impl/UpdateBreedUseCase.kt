package br.com.agrotech.domain.breed.port.api.usecase.impl

import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.domain.breed.port.api.usecase.UpdateBreed
import br.com.agrotech.domain.breed.port.spi.persistence.BreedRepository
import java.util.UUID

class UpdateBreedUseCase(
    private val breedRepository: BreedRepository
) : UpdateBreed {

    override fun update(breedId: UUID, breed: Breed): Breed {
        return breedRepository.updateBreed(breedId, breed)
    }

}