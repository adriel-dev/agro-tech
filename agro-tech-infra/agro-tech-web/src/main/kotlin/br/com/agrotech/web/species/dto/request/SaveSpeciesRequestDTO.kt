package br.com.agrotech.web.species.dto.request

import br.com.agrotech.domain.species.model.Species

data class SaveSpeciesRequestDTO(
    val name: String? = null
) {

    fun toDomainSpecies(): Species {
        return Species(
            name = this.name
        )
    }

}
