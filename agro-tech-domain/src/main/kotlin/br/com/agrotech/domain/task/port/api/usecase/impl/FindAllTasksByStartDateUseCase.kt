package br.com.agrotech.domain.task.port.api.usecase.impl

import br.com.agrotech.domain.task.model.Task
import br.com.agrotech.domain.task.port.api.usecase.FindAllTasksByStartDate
import br.com.agrotech.domain.task.port.spi.persistence.TaskRepository
import java.time.LocalDate
import java.util.*

class FindAllTasksByStartDateUseCase(
    private val taskRepository: TaskRepository
) : FindAllTasksByStartDate {

    override fun find(employeeId: UUID, startDate: LocalDate, endDate: LocalDate): List<Task> {
        return taskRepository.findAllTasksByStartDate(employeeId, startDate, endDate)
    }

}