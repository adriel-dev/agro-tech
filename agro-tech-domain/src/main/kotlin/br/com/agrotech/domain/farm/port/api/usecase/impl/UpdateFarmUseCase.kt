package br.com.agrotech.domain.farm.port.api.usecase.impl

import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.domain.farm.port.api.usecase.UpdateFarm
import br.com.agrotech.domain.farm.port.spi.persistence.FarmRepository
import java.util.*

class UpdateFarmUseCase(
    private val farmRepository: FarmRepository
) : UpdateFarm {

    override fun update(farmId: UUID, farm: Farm): Farm {
        return farmRepository.updateFarm(farmId, farm)
    }

}