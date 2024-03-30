package br.com.agrotech.persistence.task.converter

import br.com.agrotech.domain.task.model.Task
import br.com.agrotech.domain.task.model.TaskStatus
import br.com.agrotech.persistence.task.entity.TaskEntity
import br.com.agrotech.persistence.task.entity.TaskStatusEntity
import org.springframework.stereotype.Component

@Component
class TaskPersistenceConverter {

    fun taskToTaskEntity(task: Task): TaskEntity {
        return TaskEntity(
            id = task.id,
            title = task.title,
            description = task.description,
            status = task.status?.let { TaskStatusEntity.valueOf(it.toString()) },
            startDate = task.startDate,
            startedAt = task.startedAt,
            finishUntil = task.finishUntil,
            finishedAt = task.finishedAt,
            createdDate = task.createdDate,
            createdBy = task.createdBy,
            lastModifiedBy = task.lastModifiedBy,
            lastModifiedDate = task.lastModifiedDate,
            isDeleted = task.isDeleted
        )
    }
    fun taskEntityToTask(taskEntity: TaskEntity): Task {
        return Task(
            id = taskEntity.id,
            title = taskEntity.title,
            description = taskEntity.description,
            status = taskEntity.status?.let { TaskStatus.valueOf(it.toString()) },
            startDate = taskEntity.startDate,
            startedAt = taskEntity.startedAt,
            finishUntil = taskEntity.finishUntil,
            finishedAt = taskEntity.finishedAt,
            createdDate = taskEntity.createdDate,
            createdBy = taskEntity.createdBy,
            lastModifiedBy = taskEntity.lastModifiedBy,
            lastModifiedDate = taskEntity.lastModifiedDate,
            isDeleted = taskEntity.isDeleted
        )
    }

}