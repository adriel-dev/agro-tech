package br.com.agrotech.web.farm.dto

import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.web.employee.dto.EmployeeDTO
import br.com.agrotech.web.owner.dto.OwnerDTO
import java.util.*

class FarmDTO(
    val id: UUID? = null,
    val name: String? = null,
    val address: String? = null,
    val city: String? = null,
    val state: String? = null,
    val employees: List<EmployeeDTO>? = null,
    val owner: OwnerDTO? = null
) {

    fun toDomainFarm(): Farm {
        return Farm(
            this.id,
            this.name,
            this.address,
            this.city,
            this.state,
            this.employees?.map { it.toDomainEmployee() },
            this.owner?.toDomainOwner()
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
                farm.employees?.map { EmployeeDTO.fromDomainEmployee(it) },
                OwnerDTO.fromDomainOwner(farm.owner!!)
            )
        }
    }

}