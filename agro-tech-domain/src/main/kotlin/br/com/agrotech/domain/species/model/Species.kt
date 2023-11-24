package br.com.agrotech.domain.species.model

import java.util.UUID

data class Species(
    var id: UUID? = null,
    var name: String? = null
)
