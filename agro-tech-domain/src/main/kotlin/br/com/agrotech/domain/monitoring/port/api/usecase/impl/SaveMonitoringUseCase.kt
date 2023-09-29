package br.com.agrotech.domain.monitoring.port.api.usecase.impl

import br.com.agrotech.domain.monitoring.model.Monitoring
import br.com.agrotech.domain.monitoring.port.api.usecase.SaveMonitoring
import br.com.agrotech.domain.monitoring.port.spi.persistence.MonitoringRepository

class SaveMonitoringUseCase(
    private val monitoringRepository: MonitoringRepository
) : SaveMonitoring {

    override fun save(monitoring: Monitoring): Monitoring {
        return monitoringRepository.saveMonitoring(monitoring)
    }

}