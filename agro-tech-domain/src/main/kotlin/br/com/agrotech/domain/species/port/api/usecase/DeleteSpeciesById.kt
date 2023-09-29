package br.com.agrotech.domain.species.port.api.usecase

import java.util.*

interface DeleteSpeciesById {
    fun delete(speciesId: UUID)
}