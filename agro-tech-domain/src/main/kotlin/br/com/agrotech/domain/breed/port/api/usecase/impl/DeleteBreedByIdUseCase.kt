package br.com.agrotech.domain.breed.port.api.usecase.impl

import br.com.agrotech.domain.breed.port.api.usecase.DeleteBreedById
import br.com.agrotech.domain.breed.port.spi.persistence.BreedRepository
import java.util.*

class DeleteBreedByIdUseCase(
    private val breedRepository: BreedRepository
) : DeleteBreedById {

    override fun delete(breedId: UUID) {
        breedRepository.deleteBreedById(breedId)
    }

}