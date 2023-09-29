package br.com.agrotech.domain.animal.port.api.usecase

import br.com.agrotech.domain.animal.model.Animal

interface FindAllAnimals {
    fun findAllAnimals(): List<Animal>
}