package br.com.agrotech.domain.species.port.api.usecase

import br.com.agrotech.domain.species.model.Species

interface FindAllSpecies {
    fun findAllSpecies(): List<Species>
}