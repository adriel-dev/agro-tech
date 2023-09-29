package br.com.agrotech.domain.monitoring.port.spi.persistence

import br.com.agrotech.domain.monitoring.model.Monitoring
import java.util.*

interface MonitoringRepository {
    fun saveMonitoring(monitoring: Monitoring): Monitoring
    fun updateMonitoring(monitoringId: UUID, monitoring: Monitoring): Monitoring
    fun findMonitoringById(monitoringId: UUID): Monitoring
    fun findAllMonitorings(): List<Monitoring>
    fun deleteMonitoringById(monitoringId: UUID)
}