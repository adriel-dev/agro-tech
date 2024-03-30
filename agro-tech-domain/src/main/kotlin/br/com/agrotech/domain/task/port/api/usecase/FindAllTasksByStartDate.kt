package br.com.agrotech.domain.task.port.api.usecase

import br.com.agrotech.domain.pagination.DomainPage
import br.com.agrotech.domain.task.model.Task
import java.time.LocalDateTime
import java.util.UUID

interface FindAllTasksByStartDate {
    fun find(page: Int, size: Int, employeeId: UUID, startDate: LocalDateTime): DomainPage<Task>
}