package br.com.agrotech.web.monitoring.converter

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.monitoring.model.Monitoring
import br.com.agrotech.web.animal.converter.AnimalWebConverter
import br.com.agrotech.web.monitoring.dto.MonitoringDTO
import br.com.agrotech.web.monitoring.dto.request.SaveMonitoringRequestDTO
import br.com.agrotech.web.monitoring.dto.response.AnimalIdResponseDTO
import br.com.agrotech.web.monitoring.dto.response.SaveMonitoringResponseDTO
import org.springframework.stereotype.Component
import java.util.*

@Component
class MonitoringWebConverter(
    private val animalConverter: AnimalWebConverter
) {

    fun monitoringDtoToMonitoring(monitoringDTO: MonitoringDTO): Monitoring {
        return Monitoring(
            monitoringDTO.id,
            monitoringDTO.animal?.let { animalConverter.animalDtoToAnimal(it) },
            monitoringDTO.monitoringDate,
            monitoringDTO.height,
            monitoringDTO.weight,
            monitoringDTO.dewormed
        )
    }

    fun monitoringToMonitoringDto(monitoring: Monitoring): MonitoringDTO {
        return MonitoringDTO(
            monitoring.id,
            monitoring.animal?.let { animalConverter.animalToAnimalDto(it) },
            monitoring.monitoringDate,
            monitoring.height,
            monitoring.weight,
            monitoring.dewormed
        )
    }

    fun saveMonitoringRequestDtoToMonitoring(saveMonitoringRequestDTO: SaveMonitoringRequestDTO): Monitoring {
        return Monitoring(
            animal = saveMonitoringRequestDTO.animalId?.let { Animal(id = UUID.fromString(it)) },
            monitoringDate = saveMonitoringRequestDTO.monitoringDate,
            height = saveMonitoringRequestDTO.height,
            weight = saveMonitoringRequestDTO.weight,
            dewormed = saveMonitoringRequestDTO.dewormed
        )
    }

    fun monitoringToSaveMonitoringResponseDto(monitoring: Monitoring): SaveMonitoringResponseDTO {
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