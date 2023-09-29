package br.com.agrotech.domain.farm.port.api.usecase

import br.com.agrotech.domain.farm.model.Farm
import java.util.*

interface UpdateFarm {
    fun update(farmId: UUID, farm: Farm): Farm
}