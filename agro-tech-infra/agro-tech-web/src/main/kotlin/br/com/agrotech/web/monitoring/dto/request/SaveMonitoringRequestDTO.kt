package br.com.agrotech.web.monitoring.dto.request

import java.time.ZonedDateTime

data class SaveMonitoringRequestDTO(
    val animalId: String? = null,
    val monitoringDate: ZonedDateTime? = ZonedDateTime.now(),
    val height: Double? = null,
    val weight: Double? = null,
    val dewormed: Boolean? = null
)
