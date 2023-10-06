package br.com.agrotech.web.species

import br.com.agrotech.domain.species.port.api.usecase.SaveSpecies
import br.com.agrotech.domain.species.port.api.usecase.FindSpeciesById
import br.com.agrotech.domain.species.port.api.usecase.UpdateSpecies
import br.com.agrotech.domain.species.port.api.usecase.DeleteSpeciesById
import br.com.agrotech.web.species.dto.SpeciesDTO
import br.com.agrotech.web.species.dto.request.SaveSpeciesRequestDTO
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/api/v1/species")
class SpeciesController(
    private val saveSpecies: SaveSpecies,
    private val findSpeciesById: FindSpeciesById,
    private val updateSpecies: UpdateSpecies,
    private val deleteSpeciesById: DeleteSpeciesById
) {

    @PostMapping("/save")
    fun saveSpecies(@RequestBody saveSpeciesRequestDTO: SaveSpeciesRequestDTO): ResponseEntity<SpeciesDTO> {
        val createdSpecies = saveSpecies.save(saveSpeciesRequestDTO.toDomainSpecies())
        return created(URI.create("/api/v1/species/find/${createdSpecies.id.toString()}")).body(SpeciesDTO.fromDomainSpecies(createdSpecies))
    }

    @GetMapping("/find/{speciesId}")
    fun findSpecies(@PathVariable speciesId: String): ResponseEntity<SpeciesDTO> {
        val foundSpecies = SpeciesDTO.fromDomainSpecies(findSpeciesById.find(UUID.fromString(speciesId)))
        return ok().body(foundSpecies)
    }

    @PutMapping("/update/{speciesId}")
    fun updateSpecies(@PathVariable speciesId: String, @RequestBody speciesDTO: SpeciesDTO): ResponseEntity<SpeciesDTO> {
        val updatedSpecies = SpeciesDTO.fromDomainSpecies(updateSpecies.update(UUID.fromString(speciesId), speciesDTO.toDomainSpecies()))
        return ok().body(updatedSpecies)
    }

    @DeleteMapping("/delete/{speciesId}")
    fun deleteSpeciesById(@PathVariable speciesId: String): ResponseEntity<Unit> {
        deleteSpeciesById.delete(UUID.fromString(speciesId))
        return noContent().build()
    }
}
