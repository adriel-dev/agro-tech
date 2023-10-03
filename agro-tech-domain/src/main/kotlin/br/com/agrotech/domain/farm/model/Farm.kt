package br.com.agrotech.domain.farm.model

import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.domain.owner.model.Owner
import java.util.*

data class Farm(
    val id: UUID? = null,
    val name: String? = null,
    val address: String? = null,
    val city: String? = null,
    val state: String? = null,
    val employees: List<Employee>? = null,
    val owner: Owner? = null
)
