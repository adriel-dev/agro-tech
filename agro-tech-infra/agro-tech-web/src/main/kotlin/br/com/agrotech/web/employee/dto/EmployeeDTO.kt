package br.com.agrotech.web.employee.dto

import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.domain.farm.model.Farm
import java.time.LocalDate
import java.util.*

class EmployeeDTO(
    val id: UUID? = null,
    val name: String? = null,
    val lastName: String? = null,
    val birthDate: LocalDate? = null,
    val role: String? = null,
    val salary: Double? = null,
    val farm: Farm? = null
) {

    fun toDomainEmployee(): Employee {
        return Employee(
            this.id,
            this.name,
            this.lastName,
            this.birthDate,
            this.role,
            this.salary,
            this.farm
        )
    }

    companion object {
        fun fromDomainEmployee(employee: Employee): EmployeeDTO {
            return EmployeeDTO(
                employee.id,
                employee.name,
                employee.lastName,
                employee.birthDate,
                employee.role,
                employee.salary,
                employee.farm
            )
        }
    }

}