package br.com.agrotech.domain.employee.port.api.usecase.impl

import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.domain.employee.port.api.usecase.FindAllEmployees
import br.com.agrotech.domain.employee.port.spi.persistence.EmployeeRepository
import br.com.agrotech.domain.pagination.DomainPage
import java.util.UUID

class FindAllEmployeesUseCase(
    private val employeeRepository: EmployeeRepository
) : FindAllEmployees {

    override fun find(farmId: UUID, page: Int, size: Int): DomainPage<Employee> {
        return employeeRepository.findAllEmployees(farmId, page, size)
    }

}