package br.com.agrotech.domain.task.port.api.usecase

import br.com.agrotech.domain.task.model.Task

interface UpdateTask {
    fun update(task: Task): Task
}