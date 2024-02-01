package br.com.agrotech.web.monitoring.facade

import br.com.agrotech.web.monitoring.dto.MonitoringDTO
import br.com.agrotech.web.monitoring.dto.request.SaveMonitoringRequestDTO
import br.com.agrotech.web.monitoring.dto.response.SaveMonitoringResponseDTO
import java.util.UUID

interface MonitoringFacade {
    fun saveMonitoring(saveMonitoringRequestDTO: SaveMonitoringRequestDTO): SaveMonitoringResponseDTO
    fun findMonitoringById(monitoringId: UUID): MonitoringDTO
    fun updateMonitoring(monitoringId: UUID, monitoringDTO: MonitoringDTO): MonitoringDTO
    fun deleteMonitoringById(monitoringId: UUID)
}