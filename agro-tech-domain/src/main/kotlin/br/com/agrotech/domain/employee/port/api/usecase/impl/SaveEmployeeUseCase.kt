package br.com.agrotech.domain.employee.port.api.usecase.impl

import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.domain.employee.port.api.usecase.SaveEmployee
import br.com.agrotech.domain.employee.port.spi.persistence.EmployeeRepository

class SaveEmployeeUseCase(
    private val employeeRepository: EmployeeRepository
) : SaveEmployee {

    override fun save(employee: Employee): Employee {
        return employeeRepository.saveEmployee(employee)
    }

}