package br.com.agrotech.domain.task.port.spi.persistence

import br.com.agrotech.domain.task.model.Task
import java.time.LocalDate
import java.util.UUID

interface TaskRepository {
    fun findAllTasksByStartDate(employeeId: UUID, startDate: LocalDate, endDate: LocalDate): List<Task>
    fun findTaskById(taskId: UUID): Task
    fun saveTask(task: Task): Task
    fun updateTask(task: Task): Task
    fun deleteTaskById(taskId: UUID)
}