package br.com.agrotech.domain.task.model

import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.domain.task.exception.InvalidTaskStatusChangeException
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

data class Task(
    var id: UUID? = null,
    var title: String? = null,
    var description: String? = null,
    var status: TaskStatus? = TaskStatus.TO_DO,
    var employee: Employee? = null,
    var startDate: LocalDateTime? = null,
    var startedAt: LocalDateTime? = null,
    var finishUntil: LocalDateTime? = null,
    var finishedAt: LocalDateTime? = null,
    var createdDate: LocalDate? = null,
    var createdBy: String? = null,
    var lastModifiedBy: String? = null,
    var lastModifiedDate: LocalDate? = null,
    var isDeleted: Boolean = false
){

    fun markAsDoing() {
        if(this.status == TaskStatus.DONE){
            throw InvalidTaskStatusChangeException("Invalid task status change! Task with DONE status cannot be changed to DOING!")
        }
        this.status = TaskStatus.DOING
        this.startedAt = LocalDateTime.now()
    }

    fun markAsDone() {
        this.status = TaskStatus.DONE
        this.finishedAt = LocalDateTime.now()
    }

    fun logicalDelete() {
        this.isDeleted = true
    }

}

enum class TaskStatus {
    TO_DO, DOING, DONE
}