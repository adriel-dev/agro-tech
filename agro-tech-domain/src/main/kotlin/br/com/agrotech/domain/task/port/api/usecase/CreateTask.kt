package br.com.agrotech.domain.task.port.api.usecase

import br.com.agrotech.domain.task.model.Task

interface CreateTask {
    fun create(task: Task): Task
}