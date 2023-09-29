package br.com.agrotech.domain.employee.port.api.usecase

import java.util.*

interface DeleteEmployeeById {
    fun delete(employeeId: UUID)
}