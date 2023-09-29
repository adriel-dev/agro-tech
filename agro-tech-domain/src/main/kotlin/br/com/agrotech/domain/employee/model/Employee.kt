package br.com.agrotech.domain.employee.model

import br.com.agrotech.domain.farm.model.Farm
import java.time.LocalDate
import java.util.*

data class Employee(
    val id: UUID? = null,
    val name: String? = null,
    val lastName: String? = null,
    val birthDate: LocalDate? = null,
    val role: String? = null,
    val salary: Double? = null,
    val farm: Farm? = null
)
