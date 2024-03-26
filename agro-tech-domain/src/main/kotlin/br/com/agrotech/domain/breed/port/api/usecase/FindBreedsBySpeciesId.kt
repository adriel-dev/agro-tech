package br.com.agrotech.domain.breed.port.api.usecase

import br.com.agrotech.domain.breed.model.Breed
import java.util.UUID

interface FindBreedsBySpeciesId {
    fun find(speciesId: UUID): List<Breed>
}