package br.com.agrotech.domain.species.port.api.usecase

import br.com.agrotech.domain.species.model.Species
import java.util.*

interface FindSpeciesById {
    fun find(speciesId: UUID): Species
}