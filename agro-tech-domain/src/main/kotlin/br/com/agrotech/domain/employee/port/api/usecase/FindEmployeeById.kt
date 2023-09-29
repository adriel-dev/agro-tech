package br.com.agrotech.domain.employee.port.api.usecase

import br.com.agrotech.domain.employee.model.Employee
import java.util.*

interface FindEmployeeById {
    fun find(employeeId: UUID): Employee
}