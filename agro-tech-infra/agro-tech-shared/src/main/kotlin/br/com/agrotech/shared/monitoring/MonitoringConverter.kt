package br.com.agrotech.shared.monitoring

import br.com.agrotech.domain.monitoring.model.Monitoring
import br.com.agrotech.persistence.monitoring.entity.MonitoringEntity
import br.com.agrotech.web.monitoring.dto.MonitoringDTO
import br.com.agrotech.web.monitoring.dto.request.SaveMonitoringRequestDTO
import br.com.agrotech.web.monitoring.dto.response.SaveMonitoringResponseDTO

interface MonitoringConverter {
    fun monitoringEntityToMonitoring(monitoringEntity: MonitoringEntity): Monitoring
    fun monitoringToMonitoringEntity(monitoring: Monitoring): MonitoringEntity
    fun monitoringDtoToMonitoring(monitoringDTO: MonitoringDTO): Monitoring
    fun monitoringToMonitoringDto(monitoring: Monitoring): MonitoringDTO
    fun saveMonitoringRequestDtoToMonitoring(saveMonitoringRequestDTO: SaveMonitoringRequestDTO): Monitoring
    fun monitoringToSaveMonitoringResponseDto(monitoring: Monitoring): SaveMonitoringResponseDTO
}