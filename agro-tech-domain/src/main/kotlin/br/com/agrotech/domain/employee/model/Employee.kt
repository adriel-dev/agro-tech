package br.com.agrotech.domain.employee.model

import br.com.agrotech.domain.farm.model.Farm
import java.time.LocalDate
import java.util.*

data class Employee(
    var id: UUID? = null,
    var name: String? = null,
    var lastName: String? = null,
    var birthDate: LocalDate? = null,
    var role: String? = null,
    var salary: Double? = null,
    var farm: Farm? = null
)
