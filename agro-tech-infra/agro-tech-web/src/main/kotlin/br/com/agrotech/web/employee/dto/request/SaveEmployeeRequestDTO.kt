package br.com.agrotech.web.employee.dto.request

import java.time.LocalDate

data class SaveEmployeeRequestDTO(
    val name: String? = null,
    val lastName: String? = null,
    val birthDate: LocalDate? = null,
    val role: String? = null,
    val salary: Double? = null,
    val farmId: String? = null
)