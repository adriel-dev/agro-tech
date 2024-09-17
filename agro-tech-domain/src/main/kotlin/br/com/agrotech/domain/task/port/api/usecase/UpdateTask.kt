package br.com.agrotech.domain.task.port.api.usecase

import br.com.agrotech.domain.task.model.Task
import java.util.UUID

interface UpdateTask {
    fun update(taskId: UUID, task: Task): Task
}