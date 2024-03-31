package br.com.agrotech.domain.task.port.api.usecase.impl

import br.com.agrotech.domain.task.exception.InvalidStartDateException
import br.com.agrotech.domain.task.model.Task
import br.com.agrotech.domain.task.port.api.usecase.UpdateTask
import br.com.agrotech.domain.task.port.spi.persistence.TaskRepository

class UpdateTaskUseCase(
    private val taskRepository: TaskRepository
) : UpdateTask {

    override fun update(task: Task): Task {
        val startDate = task.startDate
        val finishUntil = task.finishUntil
        if(startDate != null && finishUntil != null) {
            if(startDate.isAfter(finishUntil)) {
                throw InvalidStartDateException(startDate, finishUntil)
            }
        }
        return taskRepository.updateTask(task)
    }

}