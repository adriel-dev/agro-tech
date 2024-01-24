package br.com.agrotech.persistence.employee.converter

import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.persistence.employee.entity.EmployeeEntity
import br.com.agrotech.persistence.farm.converter.FarmPersistenceConverter
import org.springframework.stereotype.Component

@Component
class EmployeePersistenceConverter(private val farmConverter: FarmPersistenceConverter) {

    fun employeeEntityToEmployee(employeeEntity: EmployeeEntity): Employee {
        return Employee(
            employeeEntity.id,
            employeeEntity.name,
            employeeEntity.lastName,
            employeeEntity.birthDate,
            employeeEntity.role,
            employeeEntity.salary,
            employeeEntity.farm?.let { farmConverter.farmEntityToFarm(it) }
        )
    }

    fun employeeToEmployeeEntity(employee: Employee): EmployeeEntity {
        return EmployeeEntity(
            employee.id,
            employee.name,
            employee.lastName,
            employee.birthDate,
            employee.role,
            employee.salary,
            employee.farm?.let { farmConverter.farmToFarmEntity(it) }
        )
    }

}