package br.com.agrotech.persistence.employee.repository

import br.com.agrotech.persistence.employee.exception.EmployeeNotFoundException
import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.domain.employee.port.spi.persistence.EmployeeRepository
import br.com.agrotech.persistence.employee.converter.EmployeePersistenceConverter
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
open class EmployeeRepositoryImpl(
    private val employeeJpaRepository: EmployeeJpaRepository,
    private val employeeConverter: EmployeePersistenceConverter
) : EmployeeRepository {

    override fun saveEmployee(employee: Employee): Employee {
        val savedEmployee = employeeJpaRepository.save(employeeConverter.employeeToEmployeeEntity(employee))
        return employeeConverter.employeeEntityToEmployee(savedEmployee)
    }

    override fun updateEmployee(employeeId: UUID, employee: Employee): Employee {
        val foundEmployee = employeeJpaRepository.findById(employeeId).orElseThrow { EmployeeNotFoundException(employeeId) }
        foundEmployee.updateFrom(employeeConverter.employeeToEmployeeEntity(employee))
        val savedEmployee = employeeJpaRepository.save(foundEmployee)
        return employeeConverter.employeeEntityToEmployee(savedEmployee)
    }

    override fun findEmployeeById(employeeId: UUID): Employee {
        val foundEmployee = employeeJpaRepository.findById(employeeId).orElseThrow { EmployeeNotFoundException(employeeId) }
        return employeeConverter.employeeEntityToEmployee(foundEmployee)
    }

    override fun findAllEmployees(): List<Employee> {
        return employeeJpaRepository.findAll().map { employeeConverter.employeeEntityToEmployee(it) }
    }

    override fun deleteEmployeeById(employeeId: UUID) {
        return employeeJpaRepository.deleteById(employeeId)
    }
}