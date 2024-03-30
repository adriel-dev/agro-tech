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
        monitoringEntity.animal?.let { this.animal = it }
        monitoringEntity.monitoringDate?.let { this.monitoringDate = it }
        monitoringEntity.height?.let { this.height = it }
        monitoringEntity.weight?.let { this.weight = it }
        monitoringEntity.dewormed?.let { this.dewormed = it }
    }

}