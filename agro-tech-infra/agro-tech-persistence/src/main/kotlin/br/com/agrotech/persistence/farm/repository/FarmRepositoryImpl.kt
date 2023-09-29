package br.com.agrotech.persistence.farm.repository

import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.domain.farm.port.spi.persistence.FarmRepository
import br.com.agrotech.persistence.farm.entity.FarmEntity
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class FarmRepositoryImpl(
    private val farmJpaRepository: FarmJpaRepository
) : FarmRepository {

    override fun saveFarm(farm: Farm): Farm {
        return farmJpaRepository.save(FarmEntity.fromDomainFarm(farm)).toDomainFarm()
    }

    override fun updateFarm(farmId: UUID, farm: Farm): Farm {
        val foundFarm = farmJpaRepository.findById(farmId).orElseThrow { RuntimeException("Farm with id [$farmId] does not exist!") }
        foundFarm.updateFrom(FarmEntity.fromDomainFarm(farm))
        return farmJpaRepository.save(foundFarm).toDomainFarm()
    }

    override fun findFarmById(farmId: UUID): Farm {
        return farmJpaRepository.findById(farmId).get().toDomainFarm()
    }

    override fun findAllFarms(): List<Farm> {
        return farmJpaRepository.findAll().map { it.toDomainFarm() }
    }

    override fun deleteFarmById(farmId: UUID) {
        return farmJpaRepository.deleteById(farmId)
    }
}