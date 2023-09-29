package br.com.agrotech.domain.employee.port.spi.persistence

import br.com.agrotech.domain.employee.model.Employee
import java.util.*

interface EmployeeRepository {
    fun saveEmployee(employee: Employee): Employee
    fun updateEmployee(employeeId: UUID, employee: Employee): Employee
    fun findEmployeeById(employeeId: UUID): Employee
    fun findAllEmployees(): List<Employee>
    fun deleteEmployeeById(employeeId: UUID)
}