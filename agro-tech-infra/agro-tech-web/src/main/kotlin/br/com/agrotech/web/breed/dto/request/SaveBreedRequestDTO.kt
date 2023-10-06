package br.com.agrotech.web.breed.dto.request

import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.domain.species.model.Species
import java.util.*

data class SaveBreedRequestDTO(
    val name: String? = null,
    val speciesId: String? = null
) {

    fun toDomainBreed(): Breed {
        return Breed(
            name = this.name,
            species = Species(id = UUID.fromString(speciesId))
        )
    }

}