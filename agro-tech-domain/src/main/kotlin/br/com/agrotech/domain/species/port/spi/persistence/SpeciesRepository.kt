package br.com.agrotech.domain.species.port.spi.persistence

import br.com.agrotech.domain.species.model.Species
import java.util.*

interface SpeciesRepository {
    fun saveSpecies(species: Species): Species
    fun updateSpecies(speciesId: UUID, species: Species): Species
    fun findSpeciesById(speciesId: UUID): Species
    fun findAllSpecies(): List<Species>
    fun deleteSpeciesById(speciesId: UUID)
}