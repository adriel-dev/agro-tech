package br.com.agrotech.domain.breed.port.api.usecase.impl

import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.domain.breed.port.api.usecase.FindBreedsBySpeciesId
import br.com.agrotech.domain.breed.port.spi.persistence.BreedRepository
import java.util.*

class FindBreedsBySpeciesIdUseCase(
    private val breedRepository: BreedRepository
) : FindBreedsBySpeciesId {

    override fun find(speciesId: UUID): List<Breed> {
        return breedRepository.findBreedsBySpeciesId(speciesId)
    }

}