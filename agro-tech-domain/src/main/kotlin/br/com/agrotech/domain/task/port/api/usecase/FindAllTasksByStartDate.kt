package br.com.agrotech.domain.task.port.api.usecase

import br.com.agrotech.domain.task.model.Task
import java.time.LocalDate
import java.util.*

interface FindAllTasksByStartDate {
    fun find(employeeId: UUID, startDate: LocalDate, endDate: LocalDate): List<Task>
}