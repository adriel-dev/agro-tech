package br.com.agrotech.domain.breed.model

import br.com.agrotech.domain.species.model.Species
import java.util.UUID

data class Breed(
    var id: UUID? = null,
    var name: String? = null,
    var species: Species? = null
)
