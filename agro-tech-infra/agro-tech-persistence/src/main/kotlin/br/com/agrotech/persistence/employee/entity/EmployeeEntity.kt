package br.com.agrotech.persistence.employee.entity

import br.com.agrotech.persistence.farm.entity.FarmEntity
import jakarta.persistence.*
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "tb_employee")
class EmployeeEntity (
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,
    var name: String? = null,
    var lastName: String? = null,
    var birthDate: LocalDate? = null,
    var role: String? = null,
    var salary: Double? = null,
    @ManyToOne @JoinColumn(name = "farm_id")
    var farm: FarmEntity? = null
) {

    fun updateFrom(employeeEntity: EmployeeEntity) {
        this.name = employeeEntity.name ?: this.name
        this.lastName = employeeEntity.lastName ?: this.lastName
        this.birthDate = employeeEntity.birthDate ?: this.birthDate
        this.role = employeeEntity.role ?: this.role
        this.salary = employeeEntity.salary ?: this.salary
        this.farm = employeeEntity.farm ?: this.farm
    }

}