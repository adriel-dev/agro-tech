package br.com.agrotech.domain.task.port.api.usecase.impl

import br.com.agrotech.domain.task.model.Task
import br.com.agrotech.domain.task.port.api.usecase.MarkTaskAsDone
import br.com.agrotech.domain.task.port.spi.persistence.TaskRepository
import java.util.*

class MarkTaskAsDoneUseCase(
    private val taskRepository: TaskRepository
) : MarkTaskAsDone {

    override fun doMark(taskId: UUID): Task {
        val foundTask = taskRepository.findTaskById(taskId)
        foundTask.markAsDone()
        return taskRepository.updateTask(foundTask)
    }

}