package br.com.agrotech.web.monitoring.dto.response

import java.time.ZonedDateTime
import java.util.*

data class SaveMonitoringResponseDTO(
    val id: UUID? = null,
    val animal: AnimalIdResponseDTO? = null,
    val monitoringDate: ZonedDateTime? = null,
    val height: Double? = null,
    val weight: Double? = null,
    val dewormed: Boolean? = null
)

data class AnimalIdResponseDTO(
    val id: UUID? = null
)