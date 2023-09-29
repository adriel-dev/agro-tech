package br.com.agrotech.domain.species.port.api.usecase.impl

import br.com.agrotech.domain.species.model.Species
import br.com.agrotech.domain.species.port.api.usecase.UpdateSpecies
import br.com.agrotech.domain.species.port.spi.persistence.SpeciesRepository
import java.util.*

class UpdateSpeciesUseCase(
    private val speciesRepository: SpeciesRepository
) : UpdateSpecies {

    override fun update(speciesId: UUID, species: Species): Species {
        return speciesRepository.updateSpecies(speciesId, species)
    }

}