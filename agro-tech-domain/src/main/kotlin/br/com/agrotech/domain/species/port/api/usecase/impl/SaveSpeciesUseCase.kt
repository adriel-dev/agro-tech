package br.com.agrotech.domain.species.port.api.usecase.impl

import br.com.agrotech.domain.species.model.Species
import br.com.agrotech.domain.species.port.api.usecase.SaveSpecies
import br.com.agrotech.domain.species.port.spi.persistence.SpeciesRepository

class SaveSpeciesUseCase(
    private val speciesRepository: SpeciesRepository
) : SaveSpecies {

    override fun save(species: Species): Species {
        return speciesRepository.saveSpecies(species)
    }

}