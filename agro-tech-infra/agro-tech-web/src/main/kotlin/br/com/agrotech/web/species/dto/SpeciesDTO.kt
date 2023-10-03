package br.com.agrotech.web.species.dto

import br.com.agrotech.domain.species.model.Species
import java.util.*

class SpeciesDTO(
    val id: UUID? = null,
    val name: String? = null
) {

    fun toDomainSpecies(): Species {
        return Species(
            this.id,
            this.name
        )
    }

    companion object {
        fun fromDomainSpecies(species: Species): SpeciesDTO {
            return SpeciesDTO(
                species.id,
                species.name
            )
        }
    }

}