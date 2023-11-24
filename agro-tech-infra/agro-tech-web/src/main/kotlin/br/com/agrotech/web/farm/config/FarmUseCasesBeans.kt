package br.com.agrotech.web.farm.config

import br.com.agrotech.domain.farm.port.api.usecase.*
import br.com.agrotech.domain.farm.port.api.usecase.impl.*
import br.com.agrotech.domain.farm.port.spi.persistence.FarmRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class FarmUseCasesBeans {

    @Bean
    open fun saveFarm(farmRepository: FarmRepository): SaveFarm {
        return SaveFarmUseCase(farmRepository)
    }

    @Bean
    open fun findFarmById(farmRepository: FarmRepository): FindFarmById {
        return FindFarmByIdUseCase(farmRepository)
    }

    @Bean
    open fun findAllFarms(farmRepository: FarmRepository): FindAllFarms {
        return FindAllFarmsUseCase(farmRepository)
    }

    @Bean
    open fun updateFarm(farmRepository: FarmRepository): UpdateFarm {
        return UpdateFarmUseCase(farmRepository)
    }

    @Bean
    open fun deleteFarmById(farmRepository: FarmRepository): DeleteFarmById {
        return DeleteFarmByIdUseCase(farmRepository)
    }

}