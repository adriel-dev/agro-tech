package br.com.agrotech.domain.task.port.api.usecase.impl

import br.com.agrotech.domain.task.port.api.usecase.DeleteTaskById
import br.com.agrotech.domain.task.port.spi.persistence.TaskRepository
import java.util.*

class DeleteTaskByIdUseCase(
    private val taskRepository: TaskRepository
) : DeleteTaskById {

    override fun delete(taskId: UUID) {
        val foundTask = taskRepository.findTaskById(taskId)
        foundTask.logicalDelete()
        taskRepository.saveTask(foundTask)
    }

}