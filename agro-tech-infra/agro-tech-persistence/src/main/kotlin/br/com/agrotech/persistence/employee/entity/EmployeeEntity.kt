package br.com.agrotech.persistence.employee.entity

import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.persistence.farm.entity.FarmEntity
import jakarta.persistence.*
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "EMPLOYEE")
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
        this.name = employeeEntity.name
        this.lastName = employeeEntity.lastName
        this.birthDate = employeeEntity.birthDate
        this.role = employeeEntity.role
        this.salary = employeeEntity.salary
        this.farm = employeeEntity.farm
    }

    fun toDomainEmployee(): Employee {
        return Employee(
            this.id,
            this.name,
            this.lastName,
            this.birthDate,
            this.role,
            this.salary,
            this.farm?.toDomainFarm()
        )
    }

    companion object {
        fun fromDomainEmployee(employee: Employee?): EmployeeEntity {
            return EmployeeEntity(
                employee?.id,
                employee?.name,
                employee?.lastName,
                employee?.birthDate,
                employee?.role,
                employee?.salary,
                FarmEntity.fromDomainFarm(employee?.farm)
            )
        }
    }

}