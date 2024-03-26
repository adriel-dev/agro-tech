package br.com.agrotech.domain.monitoring.port.api.usecase

import br.com.agrotech.domain.monitoring.model.Monitoring
import java.util.UUID

interface FindMonitoringsByAnimalId {
    fun find(animalId: UUID): List<Monitoring>
}