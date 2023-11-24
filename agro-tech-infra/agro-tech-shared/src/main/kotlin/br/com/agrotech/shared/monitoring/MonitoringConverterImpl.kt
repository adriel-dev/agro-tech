package br.com.agrotech.shared.monitoring

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.monitoring.model.Monitoring
import br.com.agrotech.persistence.monitoring.entity.MonitoringEntity
import br.com.agrotech.shared.animal.AnimalConverter
import br.com.agrotech.web.monitoring.dto.MonitoringDTO
import br.com.agrotech.web.monitoring.dto.request.SaveMonitoringRequestDTO
import br.com.agrotech.web.monitoring.dto.response.AnimalIdResponseDTO
import br.com.agrotech.web.monitoring.dto.response.SaveMonitoringResponseDTO
import org.springframework.stereotype.Component
import java.util.*

@Component
class MonitoringConverterImpl(private val animalConverter: AnimalConverter) : MonitoringConverter {

    override fun monitoringEntityToMonitoring(monitoringEntity: MonitoringEntity): Monitoring {
        return Monitoring(
            monitoringEntity.id,
            monitoringEntity.animal?.let { animalConverter.animalEntityToAnimal(it) },
            monitoringEntity.monitoringDate,
            monitoringEntity.height,
            monitoringEntity.weight,
            monitoringEntity.dewormed
        )
    }

    override fun monitoringToMonitoringEntity(monitoring: Monitoring): MonitoringEntity {
        return MonitoringEntity(
            monitoring.id,
            monitoring.animal?.let { animalConverter.animalToAnimalEntity(it) },
            monitoring.monitoringDate,
            monitoring.height,
            monitoring.weight,
            monitoring.dewormed
        )
    }

    override fun monitoringDtoToMonitoring(monitoringDTO: MonitoringDTO): Monitoring {
        return Monitoring(
            monitoringDTO.id,
            monitoringDTO.animal?.let { animalConverter.animalDtoToAnimal(it) },
            monitoringDTO.monitoringDate,
            monitoringDTO.height,
            monitoringDTO.weight,
            monitoringDTO.dewormed
        )
    }

    override fun monitoringToMonitoringDto(monitoring: Monitoring): MonitoringDTO {
        return MonitoringDTO(
            monitoring.id,
            monitoring.animal?.let { animalConverter.animalToAnimalDto(it) },
            monitoring.monitoringDate,
            monitoring.height,
            monitoring.weight,
            monitoring.dewormed
        )
    }

    override fun saveMonitoringRequestDtoToMonitoring(saveMonitoringRequestDTO: SaveMonitoringRequestDTO): Monitoring {
        return Monitoring(
            animal = saveMonitoringRequestDTO.animalId?.let { Animal(id = UUID.fromString(it)) },
            monitoringDate = saveMonitoringRequestDTO.monitoringDate,
            height = saveMonitoringRequestDTO.height,
            weight = saveMonitoringRequestDTO.weight,
            dewormed = saveMonitoringRequestDTO.dewormed
        )
    }

    override fun monitoringToSaveMonitoringResponseDto(monitoring: Monitoring): SaveMonitoringResponseDTO {
        return SaveMonitoringResponseDTO(
            id = monitoring.id,
            animal = monitoring.animal?.let { AnimalIdResponseDTO(id = it.id) },
            monitoringDate = monitoring.monitoringDate,
            height = monitoring.height,
            weight = monitoring.weight,
            dewormed = monitoring.dewormed
        )
    }

}