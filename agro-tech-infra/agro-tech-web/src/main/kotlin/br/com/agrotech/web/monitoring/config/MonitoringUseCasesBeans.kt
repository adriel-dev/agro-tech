package br.com.agrotech.web.monitoring.config

import br.com.agrotech.domain.monitoring.port.api.usecase.*
import br.com.agrotech.domain.monitoring.port.api.usecase.impl.*
import br.com.agrotech.domain.monitoring.port.spi.persistence.MonitoringRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class MonitoringUseCasesBeans {

    @Bean
    open fun saveMonitoring(monitoringRepository: MonitoringRepository): SaveMonitoring {
        return SaveMonitoringUseCase(monitoringRepository)
    }

    @Bean
    open fun findMonitoringById(monitoringRepository: MonitoringRepository): FindMonitoringById {
        return FindMonitoringByIdUseCase(monitoringRepository)
    }

    @Bean
    open fun findMonitoringsByAnimalId(monitoringRepository: MonitoringRepository): FindMonitoringsByAnimalId = FindMonitoringsByAnimalIdUseCase(monitoringRepository)

    @Bean
    open fun updateMonitoring(monitoringRepository: MonitoringRepository): UpdateMonitoring {
        return UpdateMonitoringUseCase(monitoringRepository)
    }

    @Bean
    open fun deleteMonitoringById(monitoringRepository: MonitoringRepository): DeleteMonitoringById {
        return DeleteMonitoringByIdUseCase(monitoringRepository)
    }

}