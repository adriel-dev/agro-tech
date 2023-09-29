package br.com.agrotech.persistence.monitoring.entity

import br.com.agrotech.domain.monitoring.model.Monitoring
import br.com.agrotech.persistence.animal.entity.AnimalEntity
import jakarta.persistence.*
import java.time.ZonedDateTime
import java.util.*

@Entity
@Table(name = "MONITORING")
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
        this.animal = monitoringEntity.animal
        this.monitoringDate = monitoringEntity.monitoringDate
        this.height = monitoringEntity.height
        this.weight = monitoringEntity.weight
        this.dewormed = monitoringEntity.dewormed
    }

    fun toDomainMonitoring(): Monitoring {
        return Monitoring(
            this.id,
            this.animal?.toDomainAnimal(),
            this.monitoringDate,
            this.height,
            this.weight,
            this.dewormed
        )
    }

    companion object {
        fun fromDomainMonitoring(monitoring: Monitoring?): MonitoringEntity {
            return MonitoringEntity(
                monitoring?.id,
                AnimalEntity.fromDomainAnimal(monitoring?.animal),
                monitoring?.monitoringDate,
                monitoring?.height,
                monitoring?.weight,
                monitoring?.dewormed
            )
        }
    }

}