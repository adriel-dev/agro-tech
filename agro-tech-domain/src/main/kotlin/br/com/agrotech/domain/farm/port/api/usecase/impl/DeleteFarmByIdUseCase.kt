package br.com.agrotech.domain.farm.port.api.usecase.impl

import br.com.agrotech.domain.farm.port.api.usecase.DeleteFarmById
import br.com.agrotech.domain.farm.port.spi.persistence.FarmRepository
import java.util.*

class DeleteFarmByIdUseCase(
    private val farmRepository: FarmRepository
) : DeleteFarmById {

    override fun delete(farmId: UUID) {
        farmRepository.deleteFarmById(farmId)
    }

}