package br.com.agrotech.web.employee.dto.response

import br.com.agrotech.domain.employee.model.Employee
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
){

    companion object {
        fun fromDomainEmployee(employee: Employee): SaveEmployeeResponseDTO {
            return SaveEmployeeResponseDTO(
                id = employee.id,
                name = employee.name,
                lastName = employee.lastName,
                birthDate = employee.birthDate,
                role = employee.role,
                salary = employee.salary,
                farm = FarmIdResponseDTO(employee.farm?.id)
            )
        }
    }

}

data class FarmIdResponseDTO(
    val id: UUID? = null
)