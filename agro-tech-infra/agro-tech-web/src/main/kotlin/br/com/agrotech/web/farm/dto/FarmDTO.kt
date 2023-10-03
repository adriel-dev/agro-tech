package br.com.agrotech.web.farm.dto

import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.domain.owner.model.Owner
import java.util.*

class FarmDTO(
    val id: UUID? = null,
    val name: String? = null,
    val address: String? = null,
    val city: String? = null,
    val state: String? = null,
    val employees: List<Employee>? = null,
    val owner: Owner? = null
) {

    fun toDomainFarm(): Farm {
        return Farm(
            this.id,
            this.name,
            this.address,
            this.city,
            this.state,
            this.employees,
            this.owner
        )
    }

    companion object {
        fun fromDomainFarm(farm: Farm): FarmDTO {
            return FarmDTO(
                farm.id,
                farm.name,
                farm.address,
                farm.city,
                farm.state,
                farm.employees,
                farm.owner
            )
        }
    }

}