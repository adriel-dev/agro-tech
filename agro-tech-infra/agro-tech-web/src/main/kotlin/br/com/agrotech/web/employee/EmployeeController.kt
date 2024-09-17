package br.com.agrotech.web.employee

import br.com.agrotech.domain.employee.port.api.usecase.*
import br.com.agrotech.domain.pagination.DomainPage
import br.com.agrotech.web.employee.converter.EmployeeWebConverter
import br.com.agrotech.web.employee.dto.EmployeeDTO
import br.com.agrotech.web.employee.dto.request.SaveEmployeeRequestDTO
import br.com.agrotech.web.employee.dto.response.SaveEmployeeResponseDTO
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.PositiveOrZero
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/api/v1/employee")
class EmployeeController(
    private val saveEmployee: SaveEmployee,
    private val findEmployeeById: FindEmployeeById,
    private val findAllEmployees: FindAllEmployees,
    private val updateEmployee: UpdateEmployee,
    private val deleteEmployeeById: DeleteEmployeeById,
    private val employeeConverter: EmployeeWebConverter
) {

    @PostMapping("/save")
    fun saveEmployee(@RequestBody saveEmployeeRequestDTO: SaveEmployeeRequestDTO): ResponseEntity<SaveEmployeeResponseDTO> {
        val employee = employeeConverter.saveEmployeeRequestDtoToEmployee(saveEmployeeRequestDTO)
        val createdEmployee = saveEmployee.save(employee)
        return created(URI.create("/api/v1/employee/find/${createdEmployee.id.toString()}")).body(employeeConverter.employeeToSaveEmployeeResponseDto(createdEmployee))
    }

    @GetMapping("/find/{employeeId}")
    fun findEmployee(@PathVariable employeeId: String): ResponseEntity<EmployeeDTO> {
        val foundEmployee = employeeConverter.employeeToEmployeeDto(findEmployeeById.find(UUID.fromString(employeeId)))
        return ok().body(foundEmployee)
    }

    @GetMapping("/find/all/{farmId}")
    fun findAllEmployeesByFarmId(
        @RequestParam(defaultValue = "0") @PositiveOrZero page: Int,
        @RequestParam(defaultValue = "10") @Positive @Max(100) size: Int,
        @PathVariable farmId: String
    ): ResponseEntity<DomainPage<EmployeeDTO>> {
        val employeesPage = findAllEmployees.find(UUID.fromString(farmId), page, size)
        val employeesList = employeesPage.content.map { employeeConverter.employeeToEmployeeDto(it) }
        return ok().body(DomainPage(employeesList, employeesPage.totalPages, employeesPage.totalElements, employeesPage.pageSize, employeesPage.pageNumber))
    }

    @PutMapping("/update/{employeeId}")
    fun updateEmployee(@PathVariable employeeId: String, @RequestBody employeeDTO: EmployeeDTO): ResponseEntity<EmployeeDTO> {
        val updatedEmployee = employeeConverter.employeeToEmployeeDto(updateEmployee.update(UUID.fromString(employeeId), employeeConverter.employeeDtoToEmployee(employeeDTO)))
        return ok().body(updatedEmployee)
    }

    @DeleteMapping("/delete/{employeeId}")
    fun deleteEmployeeById(@PathVariable employeeId: String): ResponseEntity<Unit> {
        deleteEmployeeById.delete(UUID.fromString(employeeId))
        return noContent().build()
    }

}