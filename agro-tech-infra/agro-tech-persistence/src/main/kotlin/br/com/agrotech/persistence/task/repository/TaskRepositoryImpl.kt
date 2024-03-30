package br.com.agrotech.persistence.task.repository

import br.com.agrotech.domain.pagination.DomainPage
import br.com.agrotech.domain.task.model.Task
import br.com.agrotech.domain.task.port.spi.persistence.TaskRepository
import br.com.agrotech.persistence.task.converter.TaskPersistenceConverter
import br.com.agrotech.persistence.task.exception.TaskNotFoundException
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
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
        page: Int,
        size: Int,
        employeeId: UUID,
        startDate: LocalDate
    ): DomainPage<Task> {
        val pageable: Pageable = PageRequest.of(page, size)
        val tasksPage = taskJpaRepository.findAllByEmployeeIdAndStartDateBetweenAndIsDeletedFalse(employeeId, startDate.atStartOfDay(), startDate.atTime(LocalTime.MAX), pageable)
        val tasksList = tasksPage.map { taskConverter.taskEntityToTask(it) }.toList()
        return DomainPage(
            content = tasksList, totalPages = tasksPage.totalPages, totalElements = tasksPage.totalElements,
            pageNumber = tasksPage.number, pageSize = tasksPage.size
        )
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
        val taskEntity = taskConverter.taskToTaskEntity(task)
        taskToUpdate.updateFrom(taskEntity)
        return taskConverter.taskEntityToTask(taskJpaRepository.save(taskToUpdate))
    }

    override fun deleteTaskById(taskId: UUID) {
        taskJpaRepository.deleteById(taskId)
    }

}