package br.com.agrotech.domain.employee.port.api.usecase

import br.com.agrotech.domain.employee.model.Employee

interface FindAllEmployees {
    fun findAllEmployees(): List<Employee>
}