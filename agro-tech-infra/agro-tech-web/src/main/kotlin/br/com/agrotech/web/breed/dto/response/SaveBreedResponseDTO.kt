package br.com.agrotech.web.breed.dto.response

import br.com.agrotech.domain.breed.model.Breed
import java.util.*

data class SaveBreedResponseDTO(
    val id: UUID? = null,
    val name: String? = null,
    val species: SpeciesIdResponseDTO? = null
) {

    companion object {
        fun fromDomainBreed(breed: Breed): SaveBreedResponseDTO {
            return SaveBreedResponseDTO(
                id = breed.id,
                name = breed.name,
                species = SpeciesIdResponseDTO(id = breed.id)
            )
        }
    }

}

data class SpeciesIdResponseDTO(
    val id: UUID? = null
)