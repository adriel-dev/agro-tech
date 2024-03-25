package br.com.agrotech.persistence.animal.entity

import br.com.agrotech.persistence.breed.entity.BreedEntity
import br.com.agrotech.persistence.farm.entity.FarmEntity
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.UUID

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "tb_animal")
class AnimalEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    @Column(unique = true)
    var externalId: String? = null,

    var name: String? = null,

    var sex: SexEnumEntity? = null,

    var acquisitionDate: LocalDate? = null,

    var saleDate: LocalDate? = null,

    var acquisitionValue: Double? = null,

    var saleValue: Double? = null,

    @ManyToOne @JoinColumn(name = "breed_id")
    var breed: BreedEntity? = null,

    @ManyToOne @JoinColumn(name = "farm_id")
    var farm: FarmEntity? = null,

    @CreatedBy
    var createdBy: String? = null,

    @CreatedDate
    var createdDate: LocalDate? = null,

    @LastModifiedBy
    var lastModifiedBy: String? = null,

    @LastModifiedDate
    var lastModifiedDate: LocalDate? = null
) {

    fun updateFrom(animalEntity: AnimalEntity) {
        this.externalId = animalEntity.externalId
        this.name = animalEntity.name ?: this.name
        this.sex = animalEntity.sex ?: this.sex
        this.acquisitionDate = animalEntity.acquisitionDate ?: this.acquisitionDate
        this.saleDate = animalEntity.saleDate ?: this.saleDate
        this.acquisitionValue = animalEntity.acquisitionValue ?: acquisitionValue
        this.saleValue = animalEntity.saleValue ?: this.saleValue
        this.breed = animalEntity.breed ?: this.breed
        this.farm = animalEntity.farm ?: this.farm
        this.createdBy = animalEntity.createdBy
        this.createdDate = animalEntity.createdDate
        this.lastModifiedBy = animalEntity.lastModifiedBy
        this.lastModifiedDate = animalEntity.lastModifiedDate
    }

    @PrePersist
    fun generateExternalId() {
        if(externalId == null) {
            val today = LocalDate.now()
            val formattedDate = today.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
            val randomSuffix = (1000..9999).random().toString()
            externalId = "$formattedDate$randomSuffix"
        }
    }

}

fun IntRange.random() = (Math.random() * (endInclusive - start) + start).toInt()

enum class SexEnumEntity {
    M, F
}