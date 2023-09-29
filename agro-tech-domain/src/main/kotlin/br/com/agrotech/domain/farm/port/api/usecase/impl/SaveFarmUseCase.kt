package br.com.agrotech.domain.farm.port.api.usecase.impl

import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.domain.farm.port.api.usecase.SaveFarm
import br.com.agrotech.domain.farm.port.spi.persistence.FarmRepository

class SaveFarmUseCase(
    private val farmRepository: FarmRepository
) : SaveFarm {

    override fun save(farm: Farm): Farm {
        return farmRepository.saveFarm(farm)
    }

}