package br.com.agrotech.domain.monitoring.model

import br.com.agrotech.domain.animal.model.Animal
import java.time.ZonedDateTime
import java.util.*

data class Monitoring(
    var id: UUID? = null,
    var animal: Animal? = null,
    var monitoringDate: ZonedDateTime? = null,
    var height: Double? = null,
    var weight: Double? = null,
    var dewormed: Boolean? = null
)
