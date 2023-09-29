package br.com.agrotech.domain.species.port.api.usecase.impl

import br.com.agrotech.domain.species.model.Species
import br.com.agrotech.domain.species.port.api.usecase.FindAllSpecies
import br.com.agrotech.domain.species.port.spi.persistence.SpeciesRepository

class FindAllSpeciesUseCase(
    private val speciesRepository: SpeciesRepository
) : FindAllSpecies {

    override fun findAllSpecies(): List<Species> {
        return speciesRepository.findAllSpecies()
    }

}