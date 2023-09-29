package br.com.agrotech.domain.monitoring.port.api.usecase

import br.com.agrotech.domain.monitoring.model.Monitoring
import java.util.*

interface UpdateMonitoring {
    fun update(monitoringId: UUID, monitoring: Monitoring): Monitoring
}