package br.com.agrotech.persistence.monitoring.repository

import br.com.agrotech.persistence.monitoring.exception.MonitoringNotFoundException
import br.com.agrotech.domain.monitoring.model.Monitoring
import br.com.agrotech.domain.monitoring.port.spi.persistence.MonitoringRepository
import br.com.agrotech.shared.monitoring.MonitoringConverter
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
open class MonitoringRepositoryImpl(
    private val monitoringJpaRepository: MonitoringJpaRepository,
    private val monitoringConverter: MonitoringConverter
) : MonitoringRepository {

    override fun saveMonitoring(monitoring: Monitoring): Monitoring {
        val monitoringEntity = monitoringConverter.monitoringToMonitoringEntity(monitoring)
        val savedMonitoring = monitoringJpaRepository.save(monitoringEntity)
        return monitoringConverter.monitoringEntityToMonitoring(savedMonitoring)
    }

    override fun updateMonitoring(monitoringId: UUID, monitoring: Monitoring): Monitoring {
        val foundMonitoring = monitoringJpaRepository.findById(monitoringId).orElseThrow { MonitoringNotFoundException(monitoringId) }
        foundMonitoring.updateFrom(monitoringConverter.monitoringToMonitoringEntity(monitoring))
        val savedMonitoring = monitoringJpaRepository.save(foundMonitoring)
        return monitoringConverter.monitoringEntityToMonitoring(savedMonitoring)
    }

    override fun findMonitoringById(monitoringId: UUID): Monitoring {
        val foundMonitoring = monitoringJpaRepository.findById(monitoringId).orElseThrow { MonitoringNotFoundException(monitoringId) }
        return monitoringConverter.monitoringEntityToMonitoring(foundMonitoring)
    }

    override fun findAllMonitorings(): List<Monitoring> {
        return monitoringJpaRepository.findAll().map { monitoringConverter.monitoringEntityToMonitoring(it) }
    }

    override fun deleteMonitoringById(monitoringId: UUID) {
        return monitoringJpaRepository.deleteById(monitoringId)
    }
}