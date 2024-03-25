package br.com.agrotech.web.monitoring.facade

import br.com.agrotech.domain.monitoring.port.api.usecase.*
import br.com.agrotech.web.monitoring.converter.MonitoringWebConverter
import br.com.agrotech.web.monitoring.dto.MonitoringDTO
import br.com.agrotech.web.monitoring.dto.request.SaveMonitoringRequestDTO
import br.com.agrotech.web.monitoring.dto.response.SaveMonitoringResponseDTO
import org.springframework.security.access.prepost.PostAuthorize
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Component
import java.util.*

@Component
open class MonitoringFacadeImpl(
    private val saveMonitoring: SaveMonitoring,
    private val findMonitoringById: FindMonitoringById,
    private val findMonitoringsByAnimalId: FindMonitoringsByAnimalId,
    private val updateMonitoring: UpdateMonitoring,
    private val deleteMonitoringById: DeleteMonitoringById,
    private val monitoringConverter: MonitoringWebConverter
) : MonitoringFacade {

    @PreAuthorize("@monitoringPermissionEvaluator.hasPermissionToSave(authentication, #saveMonitoringRequestDTO.animalId)")
    override fun saveMonitoring(saveMonitoringRequestDTO: SaveMonitoringRequestDTO): SaveMonitoringResponseDTO {
        val monitoring = monitoringConverter.saveMonitoringRequestDtoToMonitoring(saveMonitoringRequestDTO)
        val savedMonitoring = saveMonitoring.save(monitoring)
        return monitoringConverter.monitoringToSaveMonitoringResponseDto(savedMonitoring)
    }

    @PostAuthorize("@monitoringPermissionEvaluator.hasPermissionToGet(authentication, returnObject)")
    override fun findMonitoringById(monitoringId: UUID): MonitoringDTO {
        val foundMonitoring = findMonitoringById.find(monitoringId)
        return monitoringConverter.monitoringToMonitoringDto(foundMonitoring)
    }

    override fun findMonitoringsByAnimalId(animalId: UUID): List<MonitoringDTO> {
        return findMonitoringsByAnimalId.find(animalId).map { monitoringConverter.monitoringToMonitoringDto(it) }
    }

    @PreAuthorize("@monitoringPermissionEvaluator.hasPermissionToUpdateOrDelete(authentication, #monitoringId)")
    override fun updateMonitoring(monitoringId: UUID, monitoringDTO: MonitoringDTO): MonitoringDTO {
        val updatedMonitoring = updateMonitoring.update(monitoringId, monitoringConverter.monitoringDtoToMonitoring(monitoringDTO))
        return monitoringConverter.monitoringToMonitoringDto(updatedMonitoring)
    }

    @PreAuthorize("@monitoringPermissionEvaluator.hasPermissionToUpdateOrDelete(authentication, #monitoringId)")
    override fun deleteMonitoringById(monitoringId: UUID) {
        deleteMonitoringById.delete(monitoringId)
    }

}