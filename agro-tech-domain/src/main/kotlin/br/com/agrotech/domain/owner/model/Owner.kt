package br.com.agrotech.domain.owner.model

import java.time.LocalDate
import java.util.*

data class Owner(
    var id: UUID? = null,
    var name: String? = null,
    var lastName: String? = null,
    var birthDate: LocalDate? = null
)
