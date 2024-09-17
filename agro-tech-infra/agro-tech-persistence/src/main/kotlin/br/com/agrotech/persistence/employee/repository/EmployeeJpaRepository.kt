package br.com.agrotech.persistence.employee.repository

import br.com.agrotech.persistence.employee.entity.EmployeeEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface EmployeeJpaRepository : JpaRepository<EmployeeEntity, UUID> {
    fun findAllByFarmIdAndIsDeletedFalseOrderByName(farmId: UUID, pageable: Pageable): Page<EmployeeEntity>
}