package br.com.agrotech.web.monitoring.dto

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.monitoring.model.Monitoring
import java.time.ZonedDateTime
import java.util.*

class MonitoringDTO(
    val id: UUID? = null,
    val animal: Animal? = null,
    val monitoringDate: ZonedDateTime? = null,
    val height: Double? = null,
    val weight: Double? = null,
    val dewormed: Boolean? = null
) {

    fun toDomainMonitoring(): Monitoring {
        return Monitoring(
            this.id,
            this.animal,
            this.monitoringDate,
            this.height,
            this.weight,
            this.dewormed
        )
    }

    companion object {
        fun fromDomainMonitoring(monitoring: Monitoring): MonitoringDTO {
            return MonitoringDTO(
                monitoring.id,
                monitoring.animal,
                monitoring.monitoringDate,
                monitoring.height,
                monitoring.weight,
                monitoring.dewormed
            )
        }
    }

}