package br.com.agrotech.web.monitoring

import br.com.agrotech.persistence.animal.exception.AnimalNotFoundException
import br.com.agrotech.persistence.animal.repository.AnimalJpaRepository
import br.com.agrotech.persistence.monitoring.exception.MonitoringNotFoundException
import br.com.agrotech.persistence.monitoring.repository.MonitoringJpaRepository
import br.com.agrotech.persistence.user.entity.UserEntity
import br.com.agrotech.web.monitoring.dto.MonitoringDTO
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*

@Component
class MonitoringPermissionEvaluator(
    private val animalJpaRepository: AnimalJpaRepository,
    private val monitoringJpaRepository: MonitoringJpaRepository
) {

    fun hasPermissionToSave(authentication: Authentication, animalId: UUID): Boolean {
        val user = authentication.principal as UserEntity
        val animal = animalJpaRepository.findById(animalId).orElseThrow { AnimalNotFoundException(animalId) }
        val farmId = animal.farm?.id
        return user.farm?.id == farmId
    }

    fun hasPermissionToGet(authentication: Authentication, monitoring: MonitoringDTO): Boolean {
        val user = authentication.principal as UserEntity
        val farmId = monitoring.animal?.farm?.id
        return user.farm?.id == farmId
    }

    fun hasPermissionToUpdateOrDelete(authentication: Authentication, monitoringId: UUID): Boolean {
        val user = authentication.principal as UserEntity
        val monitoring = monitoringJpaRepository.findById(monitoringId).orElseThrow { MonitoringNotFoundException(monitoringId) }
        return user.farm?.id == monitoring.animal?.farm?.id
    }

}