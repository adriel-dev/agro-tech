package br.com.agrotech.web.monitoring.dto.request

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.monitoring.model.Monitoring
import java.time.ZonedDateTime
import java.util.*

data class SaveMonitoringRequestDTO(
    val animalId: String? = null,
    val monitoringDate: ZonedDateTime? = null,
    val height: Double? = null,
    val weight: Double? = null,
    val dewormed: Boolean? = null
) {

    fun toDomainMonitoring(): Monitoring {
        return Monitoring(
            animal = Animal(id = UUID.fromString(animalId)),
            monitoringDate = this.monitoringDate,
            height = this.height,
            weight = this.weight,
            dewormed = this.dewormed
        )
    }

}
