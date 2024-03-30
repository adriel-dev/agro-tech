package br.com.agrotech.web.task.dto

import br.com.agrotech.web.employee.dto.EmployeeDTO
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

data class TaskDTO(
    var id: UUID? = null,
    var title: String? = null,
    var description: String? = null,
    var status: TaskStatusDTO? = TaskStatusDTO.TO_DO,
    var employee: EmployeeDTO? = null,
    var startDate: LocalDateTime? = null,
    var startedAt: LocalDateTime? = null,
    var finishUntil: LocalDateTime? = null,
    var finishedAt: LocalDateTime? = null,
    var createdDate: LocalDate? = null,
    var createdBy: String? = null,
    var lastModifiedBy: String? = null,
    var lastModifiedDate: LocalDate? = null,
    var isDeleted: Boolean = false
)

enum class TaskStatusDTO {
    TO_DO, DOING, DONE
}
