package br.com.agrotech.web.task.dto.request

import java.time.LocalDateTime
import java.util.*

data class CreateTaskRequestDTO(
    var title: String? = null,
    var description: String? = null,
    var employeeId: UUID? = null,
    var startDate: LocalDateTime? = null,
    var finishUntil: LocalDateTime? = null,
)
