package br.com.agrotech.domain.farm.port.api.usecase.impl

import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.domain.farm.port.api.usecase.FindAllFarms
import br.com.agrotech.domain.farm.port.spi.persistence.FarmRepository

class FindAllFarmsUseCase(
    private val farmRepository: FarmRepository
) : FindAllFarms {

    override fun findAllFarms(): List<Farm> {
        return farmRepository.findAllFarms()
    }

}