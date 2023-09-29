package br.com.agrotech.domain.monitoring.port.api.usecase.impl

import br.com.agrotech.domain.monitoring.model.Monitoring
import br.com.agrotech.domain.monitoring.port.api.usecase.UpdateMonitoring
import br.com.agrotech.domain.monitoring.port.spi.persistence.MonitoringRepository
import java.util.*

class UpdateMonitoringUseCase(
    private val monitoringRepository: MonitoringRepository
) : UpdateMonitoring {

    override fun update(monitoringId: UUID, monitoring: Monitoring): Monitoring {
        return monitoringRepository.updateMonitoring(monitoringId, monitoring)
    }

}