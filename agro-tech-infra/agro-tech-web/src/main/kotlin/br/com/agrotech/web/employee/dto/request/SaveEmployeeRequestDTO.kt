package br.com.agrotech.web.employee.dto.request

import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.domain.farm.model.Farm
import java.time.LocalDate
import java.util.*

data class SaveEmployeeRequestDTO(
    val name: String? = null,
    val lastName: String? = null,
    val birthDate: LocalDate? = null,
    val role: String? = null,
    val salary: Double? = null,
    val farmId: String? = null
) {

    fun toDomainEmployee(): Employee {
        return Employee(
            name = this.name,
            lastName = this.lastName,
            birthDate = this.birthDate,
            role = this.role,
            salary = this.salary,
            farm = Farm(id = UUID.fromString(this.farmId))
        )
    }

}