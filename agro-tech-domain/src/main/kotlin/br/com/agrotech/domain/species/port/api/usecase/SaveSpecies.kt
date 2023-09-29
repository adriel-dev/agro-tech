package br.com.agrotech.domain.species.port.api.usecase

import br.com.agrotech.domain.species.model.Species

interface SaveSpecies {
    fun save(species: Species): Species
}