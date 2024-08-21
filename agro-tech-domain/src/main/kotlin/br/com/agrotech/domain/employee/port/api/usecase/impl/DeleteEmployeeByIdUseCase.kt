package br.com.agrotech.domain.employee.port.api.usecase.impl

import br.com.agrotech.domain.employee.port.api.usecase.DeleteEmployeeById
import br.com.agrotech.domain.employee.port.spi.persistence.EmployeeRepository
import java.util.*

class DeleteEmployeeByIdUseCase(
    private val employeeRepository: EmployeeRepository
) : DeleteEmployeeById {

    override fun delete(employeeId: UUID) {
        val foundEmployee = employeeRepository.findEmployeeById(employeeId)
        foundEmployee.logicalDelete()
        employeeRepository.saveEmployee(foundEmployee)
    }

}