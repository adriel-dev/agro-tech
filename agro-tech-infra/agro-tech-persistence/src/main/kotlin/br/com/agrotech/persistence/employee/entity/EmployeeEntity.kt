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
        employeeEntity.name?.let { this.name = it }
        employeeEntity.lastName?.let { this.lastName = it }
        employeeEntity.birthDate?.let { this.birthDate = it }
        employeeEntity.role?.let { this.role = it }
        employeeEntity.salary?.let { this.salary = it }
        employeeEntity.farm?.let { this.farm = it }
    }

}