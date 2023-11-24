package br.com.agrotech.shared.employee

import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.persistence.employee.entity.EmployeeEntity
import br.com.agrotech.web.employee.dto.EmployeeDTO
import br.com.agrotech.web.employee.dto.request.SaveEmployeeRequestDTO
import br.com.agrotech.web.employee.dto.response.SaveEmployeeResponseDTO

interface EmployeeConverter {
    fun employeeEntityToEmployee(employeeEntity: EmployeeEntity): Employee
    fun employeeToEmployeeEntity(employee: Employee): EmployeeEntity
    fun employeeDtoToEmployee(employeeDTO: EmployeeDTO): Employee
    fun employeeToEmployeeDto(employee: Employee): EmployeeDTO
    fun saveEmployeeRequestDtoToEmployee(saveEmployeeRequestDTO: SaveEmployeeRequestDTO): Employee
    fun employeeToSaveEmployeeResponseDto(employee: Employee): SaveEmployeeResponseDTO
}