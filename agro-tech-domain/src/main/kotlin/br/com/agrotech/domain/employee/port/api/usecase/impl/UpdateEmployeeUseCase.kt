package br.com.agrotech.domain.employee.port.api.usecase.impl

import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.domain.employee.port.api.usecase.UpdateEmployee
import br.com.agrotech.domain.employee.port.spi.persistence.EmployeeRepository
import java.util.*

class UpdateEmployeeUseCase(
    private val employeeRepository: EmployeeRepository
) : UpdateEmployee {

    override fun update(employeeId: UUID, employee: Employee): Employee {
        return employeeRepository.updateEmployee(employeeId, employee)
    }

}