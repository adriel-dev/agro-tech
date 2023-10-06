package br.com.agrotech.domain.farm.model

import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.domain.owner.model.Owner
import java.util.*

data class Farm(
    var id: UUID? = null,
    var name: String? = null,
    var address: String? = null,
    var city: String? = null,
    var state: String? = null,
    var employees: List<Employee>? = null,
    var owner: Owner? = null
)
