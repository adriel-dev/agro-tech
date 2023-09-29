package br.com.agrotech.domain.farm.port.api.usecase

import br.com.agrotech.domain.farm.model.Farm

interface FindAllFarms {
    fun findAllFarms(): List<Farm>
}