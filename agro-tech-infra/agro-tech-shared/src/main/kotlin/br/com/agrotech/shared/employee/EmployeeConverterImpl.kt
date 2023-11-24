package br.com.agrotech.shared.employee

import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.persistence.employee.entity.EmployeeEntity
import br.com.agrotech.shared.farm.FarmConverter
import br.com.agrotech.web.employee.dto.EmployeeDTO
import br.com.agrotech.web.employee.dto.request.SaveEmployeeRequestDTO
import br.com.agrotech.web.employee.dto.response.FarmIdResponseDTO
import br.com.agrotech.web.employee.dto.response.SaveEmployeeResponseDTO
import org.springframework.stereotype.Component
import java.util.*

@Component
class EmployeeConverterImpl(private val farmConverter: FarmConverter) : EmployeeConverter {

    override fun employeeEntityToEmployee(employeeEntity: EmployeeEntity): Employee {
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

    override fun employeeToEmployeeEntity(employee: Employee): EmployeeEntity {
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

    override fun employeeDtoToEmployee(employeeDTO: EmployeeDTO): Employee {
        return Employee(
            employeeDTO.id,
            employeeDTO.name,
            employeeDTO.lastName,
            employeeDTO.birthDate,
            employeeDTO.role,
            employeeDTO.salary,
            employeeDTO.farm?.let { farmConverter.farmDtoToFarm(it) }
        )
    }

    override fun employeeToEmployeeDto(employee: Employee): EmployeeDTO {
        return EmployeeDTO(
            employee.id,
            employee.name,
            employee.lastName,
            employee.birthDate,
            employee.role,
            employee.salary,
            employee.farm?.let { farmConverter.farmToFarmDto(it) }
        )
    }

    override fun saveEmployeeRequestDtoToEmployee(saveEmployeeRequestDTO: SaveEmployeeRequestDTO): Employee {
        return Employee(
            name = saveEmployeeRequestDTO.name,
            lastName = saveEmployeeRequestDTO.lastName,
            birthDate = saveEmployeeRequestDTO.birthDate,
            role = saveEmployeeRequestDTO.role,
            salary = saveEmployeeRequestDTO.salary,
            farm = saveEmployeeRequestDTO.farmId?.let { Farm(id = UUID.fromString(it)) }
        )
    }

    override fun employeeToSaveEmployeeResponseDto(employee: Employee): SaveEmployeeResponseDTO {
        return SaveEmployeeResponseDTO(
            id = employee.id,
            name = employee.name,
            lastName = employee.lastName,
            birthDate = employee.birthDate,
            role = employee.role,
            salary = employee.salary,
            farm = FarmIdResponseDTO(employee.farm?.id)
        )
    }

}