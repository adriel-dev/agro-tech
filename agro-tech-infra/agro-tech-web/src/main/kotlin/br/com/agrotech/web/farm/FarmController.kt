package br.com.agrotech.web.farm

import br.com.agrotech.domain.farm.port.api.usecase.SaveFarm
import br.com.agrotech.domain.farm.port.api.usecase.FindFarmById
import br.com.agrotech.domain.farm.port.api.usecase.UpdateFarm
import br.com.agrotech.domain.farm.port.api.usecase.DeleteFarmById
import br.com.agrotech.web.farm.converter.FarmWebConverter
import br.com.agrotech.web.farm.dto.FarmDTO
import br.com.agrotech.web.farm.dto.request.SaveFarmRequestDTO
import br.com.agrotech.web.farm.dto.response.SaveFarmResponseDTO
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/api/v1/farm")
class FarmController(
    private val saveFarm: SaveFarm,
    private val findFarmById: FindFarmById,
    private val updateFarm: UpdateFarm,
    private val deleteFarmById: DeleteFarmById,
    private val farmConverter: FarmWebConverter
) {

    @PostMapping("/save")
    fun saveFarm(@RequestBody saveFarmRequestDTO: SaveFarmRequestDTO): ResponseEntity<SaveFarmResponseDTO> {
        val farm = farmConverter.saveFarmRequestDtoToFarm(saveFarmRequestDTO)
        val createdFarm = saveFarm.save(farm)
        return created(URI.create("/api/v1/farm/find/${createdFarm.id.toString()}")).body(farmConverter.farmToSaveFarmResponseDto(createdFarm))
    }

    @GetMapping("/find/{farmId}")
    fun findFarm(@PathVariable farmId: String): ResponseEntity<FarmDTO> {
        val foundFarm = farmConverter.farmToFarmDto(findFarmById.find(UUID.fromString(farmId)))
        return ok().body(foundFarm)
    }

    @PutMapping("/update/{farmId}")
    fun updateFarm(@PathVariable farmId: String, @RequestBody farmDTO: FarmDTO): ResponseEntity<FarmDTO> {
        val updatedFarm = farmConverter.farmToFarmDto(updateFarm.update(UUID.fromString(farmId), farmConverter.farmDtoToFarm(farmDTO)))
        return ok().body(updatedFarm)
    }

    @DeleteMapping("/delete/{farmId}")
    fun deleteFarmById(@PathVariable farmId: String): ResponseEntity<Unit> {
        deleteFarmById.delete(UUID.fromString(farmId))
        return noContent().build()
    }

}
