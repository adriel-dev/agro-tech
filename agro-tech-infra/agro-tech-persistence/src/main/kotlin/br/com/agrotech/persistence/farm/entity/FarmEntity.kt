package br.com.agrotech.persistence.farm.entity

import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.persistence.animal.entity.AnimalEntity
import br.com.agrotech.persistence.employee.entity.EmployeeEntity
import br.com.agrotech.persistence.owner.entity.OwnerEntity
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "FARM")
class FarmEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,
    var name: String? = null,
    var address: String? = null,
    var city: String? = null,
    var state: String? = null,
    @OneToMany(mappedBy = "farm")
    var employees: List<EmployeeEntity>? = null,
    @OneToOne
    var owner: OwnerEntity? = null
) {

    fun updateFrom(farmEntity: FarmEntity) {
        this.name = farmEntity.name
        this.address = farmEntity.address
        this.city = farmEntity.city
        this.state = farmEntity.state
        this.employees = farmEntity.employees
        this.owner = farmEntity.owner
    }

    fun toDomainFarm(): Farm {
        return Farm(
            this.id,
            this.name,
            this.address,
            this.city,
            this.state,
            this.employees?.map { it.toDomainEmployee() },
            this.owner?.toDomainOwner()
        )
    }

    companion object {
        fun fromDomainFarm(farm: Farm?): FarmEntity {
            return FarmEntity(
                farm?.id,
                farm?.name,
                farm?.address,
                farm?.city,
                farm?.state,
                farm?.employees?.map { EmployeeEntity.fromDomainEmployee(it) },
                OwnerEntity.fromDomainOwner(farm?.owner)
            )
        }
    }

}