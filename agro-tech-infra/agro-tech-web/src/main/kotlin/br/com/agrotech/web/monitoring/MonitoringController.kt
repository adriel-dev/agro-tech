package br.com.agrotech.web.monitoring

import br.com.agrotech.web.monitoring.dto.MonitoringDTO
import br.com.agrotech.web.monitoring.dto.request.SaveMonitoringRequestDTO
import br.com.agrotech.web.monitoring.dto.response.SaveMonitoringResponseDTO
import br.com.agrotech.web.monitoring.facade.MonitoringFacade
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/api/v1/monitoring")
class MonitoringController(
    private val monitoringFacade: MonitoringFacade
) {

    @PostMapping("/save")
    fun saveMonitoring(@RequestBody saveMonitoringRequestDTO: SaveMonitoringRequestDTO): ResponseEntity<SaveMonitoringResponseDTO> {
        val responseMonitoring = monitoringFacade.saveMonitoring(saveMonitoringRequestDTO)
        return created(URI.create("/api/v1/monitoring/find/${responseMonitoring.id.toString()}")).body(responseMonitoring)
    }

    @GetMapping("/find/{monitoringId}")
    fun findMonitoring(@PathVariable monitoringId: String): ResponseEntity<MonitoringDTO> {
        val foundMonitoring = monitoringFacade.findMonitoringById(UUID.fromString(monitoringId))
        return ok().body(foundMonitoring)
    }

    @GetMapping("/find/animal/{animalId}")
    fun findMonitoringsByAnimalId(@PathVariable animalId: String): ResponseEntity<List<MonitoringDTO>> {
        return ok().body(monitoringFacade.findMonitoringsByAnimalId(UUID.fromString(animalId)))
    }

    @PutMapping("/update/{monitoringId}")
    fun updateMonitoring(@PathVariable monitoringId: String, @RequestBody monitoringDTO: MonitoringDTO): ResponseEntity<MonitoringDTO> {
        val updatedMonitoring = monitoringFacade.updateMonitoring(UUID.fromString(monitoringId), monitoringDTO)
        return ok().body(updatedMonitoring)
    }

    @DeleteMapping("/delete/{monitoringId}")
    fun deleteMonitoringById(@PathVariable monitoringId: String): ResponseEntity<Unit> {
        monitoringFacade.deleteMonitoringById(UUID.fromString(monitoringId))
        return noContent().build()
    }

}
