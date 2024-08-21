package br.com.agrotech.domain.employee.port.api.usecase

import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.domain.pagination.DomainPage
import java.util.UUID

interface FindAllEmployees {
    fun find(farmId: UUID, page: Int, size: Int): DomainPage<Employee>
}