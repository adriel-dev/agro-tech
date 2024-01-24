package br.com.agrotech.persistence.farm.converter

import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.persistence.farm.entity.FarmEntity
import org.springframework.stereotype.Component

@Component
class FarmPersistenceConverter {

    fun farmEntityToFarm(farmEntity: FarmEntity): Farm {
        return Farm(
            farmEntity.id,
            farmEntity.name,
            farmEntity.address,
            farmEntity.city,
            farmEntity.state
        )
    }

    fun farmToFarmEntity(farm: Farm): FarmEntity {
        return FarmEntity(
            farm.id,
            farm.name,
            farm.address,
            farm.city,
            farm.state
        )
    }

}