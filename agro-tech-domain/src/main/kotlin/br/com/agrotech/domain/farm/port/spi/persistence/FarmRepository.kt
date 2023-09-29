package br.com.agrotech.domain.farm.port.spi.persistence

import br.com.agrotech.domain.farm.model.Farm
import java.util.*

interface FarmRepository {
    fun saveFarm(farm: Farm): Farm
    fun updateFarm(farmId: UUID, farm: Farm): Farm
    fun findFarmById(farmId: UUID): Farm
    fun findAllFarms(): List<Farm>
    fun deleteFarmById(farmId: UUID)
}