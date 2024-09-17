package br.com.agrotech.domain.task.port.api.usecase.impl

import br.com.agrotech.domain.task.exception.InvalidStartDateException
import br.com.agrotech.domain.task.model.Task
import br.com.agrotech.domain.task.port.api.usecase.CreateTask
import br.com.agrotech.domain.task.port.spi.persistence.TaskRepository

class CreateTaskUseCase(
    private val taskRepository: TaskRepository
) : CreateTask {

    override fun create(task: Task): Task {
        val startDate = task.startDate!!
        val finishUntil = task.finishUntil!!
        if(startDate.isAfter(finishUntil)) {
            throw InvalidStartDateException(startDate, finishUntil)
        }
        return taskRepository.saveTask(task)
    }

}