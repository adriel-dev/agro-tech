package br.com.agrotech.persistence.employee.exception

import br.com.agrotech.domain.exception.NotFoundException
import java.util.UUID

class EmployeeNotFoundException(employeeId: UUID) : NotFoundException("Employee with ID [$employeeId] was not found!")