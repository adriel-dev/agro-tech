package br.com.agrotech.web.monitoring.dto.response

import br.com.agrotech.domain.monitoring.model.Monitoring
import java.time.ZonedDateTime
import java.util.*

data class SaveMonitoringResponseDTO(
    val id: UUID? = null,
    val animal: AnimalIdResponseDTO? = null,
    val monitoringDate: ZonedDateTime? = null,
    val height: Double? = null,
    val weight: Double? = null,
    val dewormed: Boolean? = null
) {

    companion object {
        fun fromDomainMonitoring(monitoring: Monitoring): SaveMonitoringResponseDTO {
            return SaveMonitoringResponseDTO(
                id = monitoring.id,
                animal = AnimalIdResponseDTO(id = monitoring.animal?.id),
                monitoringDate = monitoring.monitoringDate,
                height = monitoring.height,
                weight = monitoring.weight,
                dewormed = monitoring.dewormed
            )
        }
    }

}

data class AnimalIdResponseDTO(
    val id: UUID? = null
)