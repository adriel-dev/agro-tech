package br.com.agrotech.web.monitoring

import br.com.agrotech.domain.monitoring.port.api.usecase.SaveMonitoring
import br.com.agrotech.domain.monitoring.port.api.usecase.FindMonitoringById
import br.com.agrotech.domain.monitoring.port.api.usecase.UpdateMonitoring
import br.com.agrotech.domain.monitoring.port.api.usecase.DeleteMonitoringById
import br.com.agrotech.web.monitoring.dto.MonitoringDTO
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/api/v1/monitoring")
class MonitoringController(
    private val saveMonitoring: SaveMonitoring,
    private val findMonitoringById: FindMonitoringById,
    private val updateMonitoring: UpdateMonitoring,
    private val deleteMonitoringById: DeleteMonitoringById
) {

    @PostMapping("/save")
    fun saveMonitoring(@RequestBody monitoringDTO: MonitoringDTO): ResponseEntity<MonitoringDTO> {
        val createdMonitoring = saveMonitoring.save(monitoringDTO.toDomainMonitoring())
        return created(URI.create("/api/v1/monitoring/find/${createdMonitoring.id.toString()}")).body(MonitoringDTO.fromDomainMonitoring(createdMonitoring))
    }

    @GetMapping("/find/{monitoringId}")
    fun findMonitoring(@PathVariable monitoringId: String): ResponseEntity<MonitoringDTO> {
        val foundMonitoring = MonitoringDTO.fromDomainMonitoring(findMonitoringById.find(UUID.fromString(monitoringId)))
        return ok().body(foundMonitoring)
    }

    @PutMapping("/update/{monitoringId}")
    fun updateMonitoring(@PathVariable monitoringId: String, @RequestBody monitoringDTO: MonitoringDTO): ResponseEntity<MonitoringDTO> {
        val updatedMonitoring = MonitoringDTO.fromDomainMonitoring(updateMonitoring.update(UUID.fromString(monitoringId), monitoringDTO.toDomainMonitoring()))
        return ok().body(updatedMonitoring)
    }

    @DeleteMapping("/delete/{monitoringId}")
    fun deleteMonitoringById(@PathVariable monitoringId: String): ResponseEntity<Unit> {
        deleteMonitoringById.delete(UUID.fromString(monitoringId))
        return noContent().build()
    }

}
