package br.com.agrotech.domain.monitoring.port.api.usecase.impl

import br.com.agrotech.domain.monitoring.model.Monitoring
import br.com.agrotech.domain.monitoring.port.api.usecase.FindMonitoringById
import br.com.agrotech.domain.monitoring.port.spi.persistence.MonitoringRepository
import java.util.*

class FindMonitoringByIdUseCase(
    private val monitoringRepository: MonitoringRepository
) : FindMonitoringById {

    override fun find(monitoringId: UUID): Monitoring {
        return monitoringRepository.findMonitoringById(monitoringId)
    }

}