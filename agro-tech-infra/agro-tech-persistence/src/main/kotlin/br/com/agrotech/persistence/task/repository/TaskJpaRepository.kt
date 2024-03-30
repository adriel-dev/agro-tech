package br.com.agrotech.persistence.task.repository

import br.com.agrotech.persistence.task.entity.TaskEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.util.UUID

@Repository
interface TaskJpaRepository : JpaRepository<TaskEntity, UUID> {
    fun findAllByEmployeeIdAndStartDate(employeeId: UUID, startDate: LocalDateTime, pageable: Pageable): Page<TaskEntity>
}