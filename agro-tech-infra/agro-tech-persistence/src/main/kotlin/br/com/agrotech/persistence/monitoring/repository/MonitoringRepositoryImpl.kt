package br.com.agrotech.persistence.monitoring.repository

import br.com.agrotech.persistence.monitoring.exception.MonitoringNotFoundException
import br.com.agrotech.domain.monitoring.model.Monitoring
import br.com.agrotech.domain.monitoring.port.spi.persistence.MonitoringRepository
import br.com.agrotech.persistence.monitoring.entity.MonitoringEntity
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class MonitoringRepositoryImpl(
    private val monitoringJpaRepository: MonitoringJpaRepository
) : MonitoringRepository {

    override fun saveMonitoring(monitoring: Monitoring): Monitoring {
        return monitoringJpaRepository.save(MonitoringEntity.fromDomainMonitoring(monitoring)).toDomainMonitoring()
    }

    override fun updateMonitoring(monitoringId: UUID, monitoring: Monitoring): Monitoring {
        val foundMonitoring = monitoringJpaRepository.findById(monitoringId).orElseThrow { MonitoringNotFoundException(monitoringId) }
        foundMonitoring.updateFrom(MonitoringEntity.fromDomainMonitoring(monitoring))
        return monitoringJpaRepository.save(foundMonitoring).toDomainMonitoring()
    }

    override fun findMonitoringById(monitoringId: UUID): Monitoring {
        val foundMonitoring = monitoringJpaRepository.findById(monitoringId).orElseThrow { MonitoringNotFoundException(monitoringId) }
        return foundMonitoring.toDomainMonitoring()
    }

    override fun findAllMonitorings(): List<Monitoring> {
        return monitoringJpaRepository.findAll().map { it.toDomainMonitoring() }
    }

    override fun deleteMonitoringById(monitoringId: UUID) {
        return monitoringJpaRepository.deleteById(monitoringId)
    }
}