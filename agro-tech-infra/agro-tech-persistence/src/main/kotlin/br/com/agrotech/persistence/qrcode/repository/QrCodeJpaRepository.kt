package br.com.agrotech.persistence.qrcode.repository

import br.com.agrotech.persistence.qrcode.entity.QrCodeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface QrCodeJpaRepository : JpaRepository<QrCodeEntity, UUID> {
    fun findByAnimalId(animalId: UUID): Optional<QrCodeEntity>
}