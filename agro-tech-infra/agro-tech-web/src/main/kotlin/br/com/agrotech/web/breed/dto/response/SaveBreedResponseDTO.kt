package br.com.agrotech.web.breed.dto.response

import java.util.*

data class SaveBreedResponseDTO(
    val id: UUID? = null,
    val name: String? = null,
    val species: SpeciesIdResponseDTO? = null
)

data class SpeciesIdResponseDTO(
    val id: UUID? = null
)