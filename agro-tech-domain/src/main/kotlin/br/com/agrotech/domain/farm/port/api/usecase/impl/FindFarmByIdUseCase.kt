package br.com.agrotech.domain.farm.port.api.usecase.impl

import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.domain.farm.port.api.usecase.FindFarmById
import br.com.agrotech.domain.farm.port.spi.persistence.FarmRepository
import java.util.*

class FindFarmByIdUseCase(
    private val farmRepository: FarmRepository
) : FindFarmById {

    override fun find(farmId: UUID): Farm {
        return farmRepository.findFarmById(farmId)
    }

}