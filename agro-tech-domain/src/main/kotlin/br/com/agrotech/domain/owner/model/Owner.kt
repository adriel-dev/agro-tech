package br.com.agrotech.domain.owner.model

import java.time.LocalDate
import java.util.*

data class Owner(
    val id: UUID? = null,
    val name: String? = null,
    val lastName: String? = null,
    val birthDate: LocalDate? = null
)
