package br.com.agrotech.web.monitoring

import br.com.agrotech.domain.monitoring.port.api.usecase.SaveMonitoring
import br.com.agrotech.domain.monitoring.port.api.usecase.FindMonitoringById
import br.com.agrotech.domain.monitoring.port.api.usecase.UpdateMonitoring
import br.com.agrotech.domain.monitoring.port.api.usecase.DeleteMonitoringById
import br.com.agrotech.web.monitoring.converter.MonitoringWebConverter
import br.com.agrotech.web.monitoring.dto.MonitoringDTO
import br.com.agrotech.web.monitoring.dto.request.SaveMonitoringRequestDTO
import br.com.agrotech.web.monitoring.dto.response.SaveMonitoringResponseDTO
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/api/v1/monitoring")
open class MonitoringController(
    private val saveMonitoring: SaveMonitoring,
    private val findMonitoringById: FindMonitoringById,
    private val updateMonitoring: UpdateMonitoring,
    private val deleteMonitoringById: DeleteMonitoringById,
    private val monitoringConverter: MonitoringWebConverter
) {

    @PostMapping("/save")
    @PreAuthorize("@monitoringPermissionEvaluator.hasPermissionToSave(authentication, #saveMonitoringRequestDTO.animalId)")
    fun saveMonitoring(@RequestBody saveMonitoringRequestDTO: SaveMonitoringRequestDTO): ResponseEntity<SaveMonitoringResponseDTO> {
        val monitoring = monitoringConverter.saveMonitoringRequestDtoToMonitoring(saveMonitoringRequestDTO)
        val createdMonitoring = saveMonitoring.save(monitoring)
        return created(URI.create("/api/v1/monitoring/find/${createdMonitoring.id.toString()}")).body(monitoringConverter.monitoringToSaveMonitoringResponseDto(createdMonitoring))
    }

    @GetMapping("/find/{monitoringId}")
    fun findMonitoring(@PathVariable monitoringId: String): ResponseEntity<MonitoringDTO> {
        val foundMonitoring = monitoringConverter.monitoringToMonitoringDto(findMonitoringById.find(UUID.fromString(monitoringId)))
        return ok().body(foundMonitoring)
    }

    @PutMapping("/update/{monitoringId}")
    fun updateMonitoring(@PathVariable monitoringId: String, @RequestBody monitoringDTO: MonitoringDTO): ResponseEntity<MonitoringDTO> {
        val updatedMonitoring = monitoringConverter.monitoringToMonitoringDto(updateMonitoring.update(UUID.fromString(monitoringId), monitoringConverter.monitoringDtoToMonitoring(monitoringDTO)))
        return ok().body(updatedMonitoring)
    }

    @DeleteMapping("/delete/{monitoringId}")
    fun deleteMonitoringById(@PathVariable monitoringId: String): ResponseEntity<Unit> {
        deleteMonitoringById.delete(UUID.fromString(monitoringId))
        return noContent().build()
    }

}
