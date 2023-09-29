package br.com.agrotech.domain.employee.port.api.usecase.impl

import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.domain.employee.port.api.usecase.FindEmployeeById
import br.com.agrotech.domain.employee.port.spi.persistence.EmployeeRepository
import java.util.*

class FindEmployeeByIdUseCase(
    private val employeeRepository: EmployeeRepository
) : FindEmployeeById {

    override fun find(employeeId: UUID): Employee {
        return employeeRepository.findEmployeeById(employeeId)
    }

}