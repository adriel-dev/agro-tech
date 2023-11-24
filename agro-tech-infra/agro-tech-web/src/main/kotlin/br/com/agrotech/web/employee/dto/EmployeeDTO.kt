package br.com.agrotech.web.employee.dto

import br.com.agrotech.web.farm.dto.FarmDTO
import java.time.LocalDate
import java.util.*

class EmployeeDTO(
    val id: UUID? = null,
    val name: String? = null,
    val lastName: String? = null,
    val birthDate: LocalDate? = null,
    val role: String? = null,
    val salary: Double? = null,
    val farm: FarmDTO? = null
)