package br.com.agrotech.domain.monitoring.port.api.usecase

import br.com.agrotech.domain.monitoring.model.Monitoring

interface SaveMonitoring {
    fun save(monitoring: Monitoring): Monitoring
}