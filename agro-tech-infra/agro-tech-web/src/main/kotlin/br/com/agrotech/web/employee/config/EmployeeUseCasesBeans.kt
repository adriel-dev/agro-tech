package br.com.agrotech.web.employee.config

import br.com.agrotech.domain.employee.port.api.usecase.DeleteEmployeeById
import br.com.agrotech.domain.employee.port.api.usecase.FindEmployeeById
import br.com.agrotech.domain.employee.port.api.usecase.SaveEmployee
import br.com.agrotech.domain.employee.port.api.usecase.UpdateEmployee
import br.com.agrotech.domain.employee.port.api.usecase.impl.DeleteEmployeeByIdUseCase
import br.com.agrotech.domain.employee.port.api.usecase.impl.FindEmployeeByIdUseCase
import br.com.agrotech.domain.employee.port.api.usecase.impl.SaveEmployeeUseCase
import br.com.agrotech.domain.employee.port.api.usecase.impl.UpdateEmployeeUseCase
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
    open fun updateEmployee(employeeRepository: EmployeeRepository): UpdateEmployee {
        return UpdateEmployeeUseCase(employeeRepository)
    }

    @Bean
    open fun deleteEmployeeById(employeeRepository: EmployeeRepository): DeleteEmployeeById {
        return DeleteEmployeeByIdUseCase(employeeRepository)
    }

}