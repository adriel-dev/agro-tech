package br.com.agrotech.domain.task.port.api.usecase.impl

import br.com.agrotech.domain.task.model.Task
import br.com.agrotech.domain.task.port.api.usecase.MarkTaskAsDoing
import br.com.agrotech.domain.task.port.spi.persistence.TaskRepository
import java.util.*

class MarkTaskAsDoingUseCase(
    private val taskRepository: TaskRepository
) : MarkTaskAsDoing {

    override fun doMark(taskId: UUID): Task {
        val foundTask = taskRepository.findTaskById(taskId)
        foundTask.markAsDoing()
        return taskRepository.updateTask(foundTask)
    }

}