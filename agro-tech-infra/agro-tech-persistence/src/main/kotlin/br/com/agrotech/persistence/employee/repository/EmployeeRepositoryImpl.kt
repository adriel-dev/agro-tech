package br.com.agrotech.persistence.employee.repository

import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.domain.employee.port.spi.persistence.EmployeeRepository
import br.com.agrotech.persistence.employee.entity.EmployeeEntity
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class EmployeeRepositoryImpl(
    private val employeeJpaRepository: EmployeeJpaRepository
) : EmployeeRepository {

    override fun saveEmployee(employee: Employee): Employee {
        return employeeJpaRepository.save(EmployeeEntity.fromDomainEmployee(employee)).toDomainEmployee()
    }

    override fun updateEmployee(employeeId: UUID, employee: Employee): Employee {
        val foundEmployee = employeeJpaRepository.findById(employeeId).orElseThrow { RuntimeException("Employee with id [$employeeId] does not exist!") }
        foundEmployee.updateFrom(EmployeeEntity.fromDomainEmployee(employee))
        return employeeJpaRepository.save(foundEmployee).toDomainEmployee()
    }

    override fun findEmployeeById(employeeId: UUID): Employee {
        return employeeJpaRepository.findById(employeeId).get().toDomainEmployee()
    }

    override fun findAllEmployees(): List<Employee> {
        return employeeJpaRepository.findAll().map { it.toDomainEmployee() }
    }

    override fun deleteEmployeeById(employeeId: UUID) {
        return employeeJpaRepository.deleteById(employeeId)
    }
}