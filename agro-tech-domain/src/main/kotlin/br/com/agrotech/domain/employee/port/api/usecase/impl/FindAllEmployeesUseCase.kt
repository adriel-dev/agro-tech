package br.com.agrotech.domain.employee.port.api.usecase.impl

import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.domain.employee.port.api.usecase.FindAllEmployees
import br.com.agrotech.domain.employee.port.spi.persistence.EmployeeRepository

class FindAllEmployeesUseCase(
    private val employeeRepository: EmployeeRepository
) : FindAllEmployees {

    override fun findAllEmployees(): List<Employee> {
        return employeeRepository.findAllEmployees()
    }

}