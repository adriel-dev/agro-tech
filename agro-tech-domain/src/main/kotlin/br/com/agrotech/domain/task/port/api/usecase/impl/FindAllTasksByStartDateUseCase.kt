package br.com.agrotech.domain.task.port.api.usecase.impl

import br.com.agrotech.domain.pagination.DomainPage
import br.com.agrotech.domain.task.model.Task
import br.com.agrotech.domain.task.port.api.usecase.FindAllTasksByStartDate
import br.com.agrotech.domain.task.port.spi.persistence.TaskRepository
import java.time.LocalDate
import java.util.*

class FindAllTasksByStartDateUseCase(
    private val taskRepository: TaskRepository
) : FindAllTasksByStartDate {

    override fun find(page: Int, size: Int, employeeId: UUID, startDate: LocalDate): DomainPage<Task> {
        return taskRepository.findAllTasksByStartDate(page, size, employeeId, startDate)
    }

}