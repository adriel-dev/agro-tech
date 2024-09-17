package br.com.agrotech.persistence.task.entity

import br.com.agrotech.persistence.employee.entity.EmployeeEntity
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "tb_task")
class TaskEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,
    var title: String? = null,
    var description: String? = null,
    var status: TaskStatusEntity? = TaskStatusEntity.TO_DO,
    @ManyToOne @JoinColumn(name = "employee_id")
    var employee: EmployeeEntity? = null,
    var startDate: LocalDateTime? = null,
    var startedAt: LocalDateTime? = null,
    var finishUntil: LocalDateTime? = null,
    var finishedAt: LocalDateTime? = null,
    @CreatedDate
    var createdDate: LocalDate? = null,
    @CreatedBy
    var createdBy: String? = null,
    @LastModifiedBy
    var lastModifiedBy: String? = null,
    @LastModifiedDate
    var lastModifiedDate: LocalDate? = null,
    var isDeleted: Boolean = false
){

    fun updateFrom(taskEntity: TaskEntity) {
        taskEntity.title?.let { this.title = it }
        taskEntity.description?.let { this.description = it }
        taskEntity.status?.let { this.status = it }
        taskEntity.employee?.let { this.employee = it }
        taskEntity.startDate?.let { this.startDate = it }
        taskEntity.startedAt?.let { this.startedAt = it }
        taskEntity.finishUntil?.let { this.finishUntil = it }
        taskEntity.finishedAt?.let { this.finishedAt = it }
        taskEntity.createdDate?.let { this.createdDate = it }
        taskEntity.createdBy?.let { this.createdBy = it }
        taskEntity.lastModifiedBy?.let { this.lastModifiedBy = it }
        taskEntity.lastModifiedDate?.let { this.lastModifiedDate = it }
        this.isDeleted = taskEntity.isDeleted
    }


}

enum class TaskStatusEntity {
    TO_DO, DOING, DONE
}