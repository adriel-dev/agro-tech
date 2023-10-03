package br.com.agrotech.web.breed.dto

import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.domain.species.model.Species
import java.util.*

class BreedDTO(
    val id: UUID? = null,
    val name: String? = null,
    val species: Species? = null
) {

    fun toDomainBreed(): Breed {
        return Breed(
            this.id,
            this.name,
            this.species
        )
    }

    companion object {
        fun fromDomainBreed(breed: Breed): BreedDTO {
            return BreedDTO(
                breed.id,
                breed.name,
                breed.species
            )
        }
    }

}