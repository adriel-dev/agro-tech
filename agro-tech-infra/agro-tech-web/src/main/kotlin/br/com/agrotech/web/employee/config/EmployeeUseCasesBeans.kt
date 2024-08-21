package br.com.agrotech.web.employee.config

import br.com.agrotech.domain.employee.port.api.usecase.*
import br.com.agrotech.domain.employee.port.api.usecase.impl.*
import br.com.agrotech.domain.employee.port.spi.persistence.EmployeeRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class EmployeeUseCasesBeans {

    @Bean
    open fun saveEmployee(employeeRepository: EmployeeRepository): SaveEmployee {
        return SaveEmployeeUseCase(employeeRepository)
    }

    @Bean
    open fun findEmployeeById(employeeRepository: EmployeeRepository): FindEmployeeById {
        return FindEmployeeByIdUseCase(employeeRepository)
    }

    @Bean
    open fun findAllEmployees(employeeRepository: EmployeeRepository): FindAllEmployees = FindAllEmployeesUseCase(employeeRepository)

    @Bean
    open fun updateEmployee(employeeRepository: EmployeeRepository): UpdateEmployee {
        return UpdateEmployeeUseCase(employeeRepository)
    }

    @Bean
    open fun deleteEmployeeById(employeeRepository: EmployeeRepository): DeleteEmployeeById {
        return DeleteEmployeeByIdUseCase(employeeRepository)
    }

}