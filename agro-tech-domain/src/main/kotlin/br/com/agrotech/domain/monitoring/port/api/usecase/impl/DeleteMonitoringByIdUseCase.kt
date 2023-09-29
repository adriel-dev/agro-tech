package br.com.agrotech.domain.monitoring.port.api.usecase.impl

import br.com.agrotech.domain.monitoring.port.api.usecase.DeleteMonitoringById
import br.com.agrotech.domain.monitoring.port.spi.persistence.MonitoringRepository
import java.util.*

class DeleteMonitoringByIdUseCase(
    private val monitoringRepository: MonitoringRepository
) : DeleteMonitoringById {

    override fun delete(monitoringId: UUID) {
        monitoringRepository.deleteMonitoringById(monitoringId)
    }

}