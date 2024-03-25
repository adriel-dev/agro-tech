package br.com.agrotech.web.species

import br.com.agrotech.domain.species.port.api.usecase.*
import br.com.agrotech.web.species.converter.SpeciesWebConverter
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
    private val findAllSpecies: FindAllSpecies,
    private val updateSpecies: UpdateSpecies,
    private val deleteSpeciesById: DeleteSpeciesById,
    private val speciesConverter: SpeciesWebConverter
) {

    @PostMapping("/save")
    fun saveSpecies(@RequestBody saveSpeciesRequestDTO: SaveSpeciesRequestDTO): ResponseEntity<SpeciesDTO> {
        val species = speciesConverter.saveSpeciesRequestDtoToSpecies(saveSpeciesRequestDTO)
        val createdSpecies = saveSpecies.save(species)
        return created(URI.create("/api/v1/species/find/${createdSpecies.id.toString()}")).body(speciesConverter.speciesToSpeciesDto(createdSpecies))
    }

    @GetMapping("/find/all")
    fun findAllSpecies(): ResponseEntity<List<SpeciesDTO>> {
        val foundSpecies = findAllSpecies.findAllSpecies().map { speciesConverter.speciesToSpeciesDto(it) }
        return ok().body(foundSpecies)
    }

    @GetMapping("/find/{speciesId}")
    fun findSpecies(@PathVariable speciesId: String): ResponseEntity<SpeciesDTO> {
        val foundSpecies = speciesConverter.speciesToSpeciesDto(findSpeciesById.find(UUID.fromString(speciesId)))
        return ok().body(foundSpecies)
    }

    @PutMapping("/update/{speciesId}")
    fun updateSpecies(@PathVariable speciesId: String, @RequestBody speciesDTO: SpeciesDTO): ResponseEntity<SpeciesDTO> {
        val updatedSpecies = speciesConverter.speciesToSpeciesDto(updateSpecies.update(UUID.fromString(speciesId), speciesConverter.speciesDtoToSpecies(speciesDTO)))
        return ok().body(updatedSpecies)
    }

    @DeleteMapping("/delete/{speciesId}")
    fun deleteSpeciesById(@PathVariable speciesId: String): ResponseEntity<Unit> {
        deleteSpeciesById.delete(UUID.fromString(speciesId))
        return noContent().build()
    }
}
