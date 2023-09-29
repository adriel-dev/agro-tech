package br.com.agrotech.domain.species.port.api.usecase.impl

import br.com.agrotech.domain.species.model.Species
import br.com.agrotech.domain.species.port.api.usecase.FindSpeciesById
import br.com.agrotech.domain.species.port.spi.persistence.SpeciesRepository
import java.util.*

class FindSpeciesByIdUseCase(
    private val speciesRepository: SpeciesRepository
) : FindSpeciesById {

    override fun find(speciesId: UUID): Species {
        return speciesRepository.findSpeciesById(speciesId)
    }

}