package br.com.agrotech.web.monitoring.dto

import br.com.agrotech.web.animal.dto.AnimalDTO
import java.time.ZonedDateTime
import java.util.*

data class MonitoringDTO(
    val id: UUID? = null,
    val animal: AnimalDTO? = null,
    val monitoringDate: ZonedDateTime? = null,
    val height: Double? = null,
    val weight: Double? = null,
    val dewormed: Boolean? = null
)