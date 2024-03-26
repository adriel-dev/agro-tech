package br.com.agrotech.domain.monitoring.port.api.usecase.impl

import br.com.agrotech.domain.monitoring.model.Monitoring
import br.com.agrotech.domain.monitoring.port.api.usecase.FindMonitoringsByAnimalId
import br.com.agrotech.domain.monitoring.port.spi.persistence.MonitoringRepository
import java.util.*

class FindMonitoringsByAnimalIdUseCase(
    private val monitoringRepository: MonitoringRepository
) : FindMonitoringsByAnimalId {

    override fun find(animalId: UUID): List<Monitoring> {
        return monitoringRepository.findMonitoringsByAnimalId(animalId)
    }

}