package br.com.agrotech.web.breed.dto

import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.web.species.dto.SpeciesDTO
import java.util.*

class BreedDTO(
    val id: UUID? = null,
    val name: String? = null,
    val species: SpeciesDTO? = null
) {

    fun toDomainBreed(): Breed {
        return Breed(
            this.id,
            this.name,
            this.species?.toDomainSpecies()
        )
    }

    companion object {
        fun fromDomainBreed(breed: Breed): BreedDTO {
            return BreedDTO(
                breed.id,
                breed.name,
                SpeciesDTO.fromDomainSpecies(breed.species!!)
            )
        }
    }

}