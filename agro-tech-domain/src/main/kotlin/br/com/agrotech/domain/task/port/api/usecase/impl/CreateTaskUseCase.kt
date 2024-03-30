package br.com.agrotech.domain.task.port.api.usecase.impl

import br.com.agrotech.domain.task.model.Task
import br.com.agrotech.domain.task.port.api.usecase.CreateTask
import br.com.agrotech.domain.task.port.spi.persistence.TaskRepository

class CreateTaskUseCase(
    private val taskRepository: TaskRepository
) : CreateTask {

    override fun create(task: Task): Task {
        return taskRepository.saveTask(task)
    }

}