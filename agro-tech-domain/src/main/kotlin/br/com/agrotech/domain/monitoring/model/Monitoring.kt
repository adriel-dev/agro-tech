package br.com.agrotech.domain.monitoring.model

import br.com.agrotech.domain.animal.model.Animal
import java.time.ZonedDateTime
import java.util.*

data class Monitoring(
    val id: UUID? = null,
    val animal: Animal? = null,
    val monitoringDate: ZonedDateTime? = null,
    val height: Double? = null,
    val weight: Double? = null,
    val dewormed: Boolean? = null
)
