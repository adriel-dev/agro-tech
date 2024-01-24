package br.com.agrotech.web.employee.converter

import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.web.employee.dto.EmployeeDTO
import br.com.agrotech.web.employee.dto.request.SaveEmployeeRequestDTO
import br.com.agrotech.web.employee.dto.response.FarmIdResponseDTO
import br.com.agrotech.web.employee.dto.response.SaveEmployeeResponseDTO
import br.com.agrotech.web.farm.converter.FarmWebConverter
import org.springframework.stereotype.Component
import java.util.*

@Component
class EmployeeWebConverter(
    private val farmConverter: FarmWebConverter
) {

    fun employeeDtoToEmployee(employeeDTO: EmployeeDTO): Employee {
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

    fun employeeToEmployeeDto(employee: Employee): EmployeeDTO {
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

    fun saveEmployeeRequestDtoToEmployee(saveEmployeeRequestDTO: SaveEmployeeRequestDTO): Employee {
        return Employee(
            name = saveEmployeeRequestDTO.name,
            lastName = saveEmployeeRequestDTO.lastName,
            birthDate = saveEmployeeRequestDTO.birthDate,
            role = saveEmployeeRequestDTO.role,
            salary = saveEmployeeRequestDTO.salary,
            farm = saveEmployeeRequestDTO.farmId?.let { Farm(id = UUID.fromString(it)) }
        )
    }

    fun employeeToSaveEmployeeResponseDto(employee: Employee): SaveEmployeeResponseDTO {
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