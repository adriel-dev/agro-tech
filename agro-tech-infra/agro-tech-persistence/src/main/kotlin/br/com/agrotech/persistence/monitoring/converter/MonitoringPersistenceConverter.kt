package br.com.agrotech.persistence.monitoring.converter

import br.com.agrotech.domain.monitoring.model.Monitoring
import br.com.agrotech.persistence.animal.converter.AnimalPersistenceConverter
import br.com.agrotech.persistence.monitoring.entity.MonitoringEntity
import org.springframework.stereotype.Component

@Component
class MonitoringPersistenceConverter(private val animalConverter: AnimalPersistenceConverter) {

    fun monitoringEntityToMonitoring(monitoringEntity: MonitoringEntity): Monitoring {
        return Monitoring(
            monitoringEntity.id,
            monitoringEntity.animal?.let { animalConverter.animalEntityToAnimal(it) },
            monitoringEntity.monitoringDate,
            monitoringEntity.height,
            monitoringEntity.weight,
            monitoringEntity.dewormed
        )
    }

    fun monitoringToMonitoringEntity(monitoring: Monitoring): MonitoringEntity {
        return MonitoringEntity(
            monitoring.id,
            monitoring.animal?.let { animalConverter.animalToAnimalEntity(it) },
            monitoring.monitoringDate,
            monitoring.height,
            monitoring.weight,
            monitoring.dewormed
        )
    }

}