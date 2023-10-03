package br.com.agrotech.web.employee

import br.com.agrotech.domain.employee.port.api.usecase.SaveEmployee
import br.com.agrotech.domain.employee.port.api.usecase.FindEmployeeById
import br.com.agrotech.domain.employee.port.api.usecase.UpdateEmployee
import br.com.agrotech.domain.employee.port.api.usecase.DeleteEmployeeById
import br.com.agrotech.web.employee.dto.EmployeeDTO
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
    private val updateEmployee: UpdateEmployee,
    private val deleteEmployeeById: DeleteEmployeeById
) {

    @PostMapping("/save")
    fun saveEmployee(@RequestBody employeeDTO: EmployeeDTO): ResponseEntity<EmployeeDTO> {
        val createdEmployee = saveEmployee.save(employeeDTO.toDomainEmployee())
        return created(URI.create("/api/v1/employee/find/${createdEmployee.id.toString()}")).body(EmployeeDTO.fromDomainEmployee(createdEmployee))
    }

    @GetMapping("/find/{employeeId}")
    fun findEmployee(@PathVariable employeeId: String): ResponseEntity<EmployeeDTO> {
        val foundEmployee = EmployeeDTO.fromDomainEmployee(findEmployeeById.find(UUID.fromString(employeeId)))
        return ok().body(foundEmployee)
    }

    @PutMapping("/update/{employeeId}")
    fun updateEmployee(@PathVariable employeeId: String, @RequestBody employeeDTO: EmployeeDTO): ResponseEntity<EmployeeDTO> {
        val updatedEmployee = EmployeeDTO.fromDomainEmployee(updateEmployee.update(UUID.fromString(employeeId), employeeDTO.toDomainEmployee()))
        return ok().body(updatedEmployee)
    }

    @DeleteMapping("/delete/{employeeId}")
    fun deleteEmployeeById(@PathVariable employeeId: String): ResponseEntity<Unit> {
        deleteEmployeeById.delete(UUID.fromString(employeeId))
        return noContent().build()
    }

}