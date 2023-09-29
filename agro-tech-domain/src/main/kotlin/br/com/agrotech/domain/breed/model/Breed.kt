package br.com.agrotech.domain.breed.model

import br.com.agrotech.domain.species.model.Species
import java.util.UUID

data class Breed(
    val id: UUID? = null,
    val name: String? = null,
    val species: Species? = null
)
