package br.com.agrotech.web.employee.dto.response

import java.time.LocalDate
import java.util.*

data class SaveEmployeeResponseDTO(
    val id: UUID? = null,
    val name: String? = null,
    val lastName: String? = null,
    val birthDate: LocalDate? = null,
    val role: String? = null,
    val salary: Double? = null,
    val farm: FarmIdResponseDTO? = null
)

data class FarmIdResponseDTO(
    val id: UUID? = null
)