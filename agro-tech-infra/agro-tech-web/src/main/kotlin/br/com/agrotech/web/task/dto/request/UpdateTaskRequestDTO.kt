package br.com.agrotech.web.task.dto.request

import java.time.LocalDateTime

data class UpdateTaskRequestDTO(
    var title: String? = null,
    var description: String? = null,
    var startDate: LocalDateTime? = null,
    var finishUntil: LocalDateTime? = null
)