package br.com.agrotech.domain.employee.port.spi.persistence

import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.domain.pagination.DomainPage
import java.util.*

interface EmployeeRepository {
    fun saveEmployee(employee: Employee): Employee
    fun updateEmployee(employeeId: UUID, employee: Employee): Employee
    fun findEmployeeById(employeeId: UUID): Employee
    fun findAllEmployees(farmId: UUID, page: Int, size: Int): DomainPage<Employee>
    fun deleteEmployeeById(employeeId: UUID)
}