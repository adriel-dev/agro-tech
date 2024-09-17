package br.com.agrotech.persistence.employee.repository

import br.com.agrotech.persistence.employee.exception.EmployeeNotFoundException
import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.domain.employee.port.spi.persistence.EmployeeRepository
import br.com.agrotech.domain.pagination.DomainPage
import br.com.agrotech.persistence.employee.converter.EmployeePersistenceConverter
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
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

    override fun findAllEmployees(farmId: UUID, page: Int, size: Int): DomainPage<Employee> {
        val pageable: Pageable = PageRequest.of(page, size)
        val employeePage = employeeJpaRepository.findAllByFarmIdAndIsDeletedFalseOrderByName(farmId, pageable)
        val employeeList = employeePage.map { employeeConverter.employeeEntityToEmployee(it) }.toList()
        return DomainPage(employeeList, employeePage.totalPages, employeePage.totalElements, employeePage.size, employeePage.number)
    }

    override fun deleteEmployeeById(employeeId: UUID) {
        return employeeJpaRepository.deleteById(employeeId)
    }
}