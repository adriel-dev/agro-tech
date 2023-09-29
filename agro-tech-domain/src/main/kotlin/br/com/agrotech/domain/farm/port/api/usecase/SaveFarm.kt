package br.com.agrotech.domain.farm.port.api.usecase

import br.com.agrotech.domain.farm.model.Farm

interface SaveFarm {
    fun save(farm: Farm): Farm
}