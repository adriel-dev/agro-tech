package br.com.agrotech.persistence.monitoring.exception

import br.com.agrotech.domain.exception.NotFoundException
import java.util.UUID

class MonitoringNotFoundException(monitoringId: UUID) : NotFoundException("Monitoring with ID [$monitoringId] was not found!")