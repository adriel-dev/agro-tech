package br.com.agrotech.domain.employee.port.api.usecase

import br.com.agrotech.domain.employee.model.Employee

interface SaveEmployee {
    fun save(employee: Employee): Employee
}