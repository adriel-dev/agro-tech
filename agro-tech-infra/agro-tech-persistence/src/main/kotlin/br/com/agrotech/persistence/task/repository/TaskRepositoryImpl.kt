package br.com.agrotech.persistence.task.repository

import br.com.agrotech.domain.task.exception.TaskUpdateNotAllowedException
import br.com.agrotech.domain.task.model.Task
import br.com.agrotech.domain.task.port.spi.persistence.TaskRepository
import br.com.agrotech.persistence.task.converter.TaskPersistenceConverter
import br.com.agrotech.persistence.task.entity.TaskStatusEntity
import br.com.agrotech.persistence.task.exception.TaskNotFoundException
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

@Repository
open class TaskRepositoryImpl(
    private val taskJpaRepository: TaskJpaRepository,
    private val taskConverter: TaskPersistenceConverter
) : TaskRepository {
    override fun findAllTasksByStartDate(
        employeeId: UUID,
        startDate: LocalDate,
        endDate: LocalDate
    ): List<Task> {
        val tasksEntityList = taskJpaRepository.findAllByEmployeeIdAndStartDateBetweenAndIsDeletedFalse(employeeId, startDate.atStartOfDay(), endDate.atTime(23, 59))
        return tasksEntityList.map { taskConverter.taskEntityToTask(it) }.toList()
    }

    override fun findTaskById(taskId: UUID): Task {
        val foundTask = taskJpaRepository.findById(taskId).orElseThrow { TaskNotFoundException(taskId) }
        return taskConverter.taskEntityToTask(foundTask)
    }

    override fun saveTask(task: Task): Task {
        val taskToSave = taskConverter.taskToTaskEntity(task)
        return taskConverter.taskEntityToTask(taskJpaRepository.save(taskToSave))
    }

    override fun updateTask(task: Task): Task {
        val taskId = task.id!!
        val taskToUpdate = taskJpaRepository.findById(taskId).orElseThrow { TaskNotFoundException(taskId) }
        if(taskToUpdate.status == TaskStatusEntity.DONE) {
            throw TaskUpdateNotAllowedException("Task with 'DONE' status cannot be updated!")
        }
        val taskEntity = taskConverter.taskToTaskEntity(task)
        taskToUpdate.updateFrom(taskEntity)
        return taskConverter.taskEntityToTask(taskJpaRepository.save(taskToUpdate))
    }

    override fun deleteTaskById(taskId: UUID) {
        taskJpaRepository.deleteById(taskId)
    }

}