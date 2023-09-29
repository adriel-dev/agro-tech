package br.com.agrotech.domain.monitoring.port.api.usecase

import java.util.*

interface DeleteMonitoringById {
    fun delete(monitoringId: UUID)
}