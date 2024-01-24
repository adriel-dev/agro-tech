package br.com.agrotech.persistence.farm.repository

import br.com.agrotech.persistence.farm.exception.FarmNotFoundException
import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.domain.farm.port.spi.persistence.FarmRepository
import br.com.agrotech.persistence.farm.converter.FarmPersistenceConverter
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
open class FarmRepositoryImpl(
    private val farmJpaRepository: FarmJpaRepository,
    private val farmConverter: FarmPersistenceConverter
) : FarmRepository {

    override fun saveFarm(farm: Farm): Farm {
        val farmEntity = farmConverter.farmToFarmEntity(farm)
        val savedFarm = farmJpaRepository.save(farmEntity)
        return farmConverter.farmEntityToFarm(savedFarm)
    }

    override fun updateFarm(farmId: UUID, farm: Farm): Farm {
        val foundFarm = farmJpaRepository.findById(farmId).orElseThrow { FarmNotFoundException(farmId) }
        foundFarm.updateFrom(farmConverter.farmToFarmEntity(farm))
        val savedFarm = farmJpaRepository.save(foundFarm)
        return farmConverter.farmEntityToFarm(savedFarm)
    }

    override fun findFarmById(farmId: UUID): Farm {
        val foundFarm = farmJpaRepository.findById(farmId).orElseThrow { FarmNotFoundException(farmId) }
        return farmConverter.farmEntityToFarm(foundFarm)
    }

    override fun findAllFarms(): List<Farm> {
        return farmJpaRepository.findAll().map { farmConverter.farmEntityToFarm(it) }
    }

    override fun deleteFarmById(farmId: UUID) {
        return farmJpaRepository.deleteById(farmId)
    }
}