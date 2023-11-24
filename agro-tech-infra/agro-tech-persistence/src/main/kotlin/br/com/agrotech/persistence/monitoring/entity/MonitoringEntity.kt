package br.com.agrotech.persistence.monitoring.entity

import br.com.agrotech.persistence.animal.entity.AnimalEntity
import jakarta.persistence.*
import java.time.ZonedDateTime
import java.util.*

@Entity
@Table(name = "tb_monitoring")
class MonitoringEntity (
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,
    @ManyToOne @JoinColumn(name = "animal_id")
    var animal: AnimalEntity? = null,
    var monitoringDate: ZonedDateTime? = null,
    var height: Double? = null,
    var weight: Double? = null,
    var dewormed: Boolean? = null
) {

    fun updateFrom(monitoringEntity: MonitoringEntity) {
        this.animal = monitoringEntity.animal ?: this.animal
        this.monitoringDate = monitoringEntity.monitoringDate ?: this.monitoringDate
        this.height = monitoringEntity.height ?: this.height
        this.weight = monitoringEntity.weight ?: this.weight
        this.dewormed = monitoringEntity.dewormed ?: this.dewormed
    }

}