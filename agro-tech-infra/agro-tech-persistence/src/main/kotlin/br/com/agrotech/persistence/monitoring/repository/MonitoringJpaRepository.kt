package br.com.agrotech.persistence.monitoring.repository

import br.com.agrotech.persistence.monitoring.entity.MonitoringEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface MonitoringJpaRepository : JpaRepository<MonitoringEntity, UUID> {
    fun findMonitoringByAnimalIdOrderByMonitoringDateDesc(animalId: UUID): List<MonitoringEntity>
}