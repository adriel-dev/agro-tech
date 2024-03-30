package br.com.agrotech.domain.task.port.api.usecase

import java.util.UUID

interface DeleteTaskById {
    fun delete(taskId: UUID)
}