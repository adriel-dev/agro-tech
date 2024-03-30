package br.com.agrotech.domain.task.port.spi.persistence

import br.com.agrotech.domain.pagination.DomainPage
import br.com.agrotech.domain.task.model.Task
import java.time.LocalDateTime
import java.util.UUID

interface TaskRepository {
    fun findAllTasksByStartDate(page: Int, size: Int, employeeId: UUID, startDate: LocalDateTime): DomainPage<Task>
    fun findTaskById(taskId: UUID): Task
    fun saveTask(task: Task): Task
    fun updateTask(task: Task): Task
    fun deleteTaskById(taskId: UUID)
}