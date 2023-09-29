package br.com.agrotech.persistence.owner.entity

import br.com.agrotech.domain.owner.model.Owner
import jakarta.persistence.*
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "OWNER")
class OwnerEntity (
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,
    var name: String? = null,
    var lastName: String? = null,
    var birthDate: LocalDate? = null
) {

    fun updateFrom(ownerEntity: OwnerEntity) {
        this.name = ownerEntity.name
        this.lastName = ownerEntity.lastName
        this.birthDate = ownerEntity.birthDate
    }

    fun toDomainOwner(): Owner {
        return Owner(
            this.id,
            this.name,
            this.lastName,
            this.birthDate
        )
    }

    companion object {
        fun fromDomainOwner(owner: Owner?): OwnerEntity {
            return OwnerEntity(
                owner?.id,
                owner?.name,
                owner?.lastName,
                owner?.birthDate
            )
        }
    }

}