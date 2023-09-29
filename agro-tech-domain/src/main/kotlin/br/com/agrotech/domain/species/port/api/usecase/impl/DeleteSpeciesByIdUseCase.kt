package br.com.agrotech.domain.species.port.api.usecase.impl

import br.com.agrotech.domain.species.port.api.usecase.DeleteSpeciesById
import br.com.agrotech.domain.species.port.spi.persistence.SpeciesRepository
import java.util.*

class DeleteSpeciesByIdUseCase(
    private val speciesRepository: SpeciesRepository
) : DeleteSpeciesById {

    override fun delete(speciesId: UUID) {
        speciesRepository.deleteSpeciesById(speciesId)
    }

}