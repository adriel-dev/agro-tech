package br.com.agrotech.web.breed

import br.com.agrotech.domain.breed.port.api.usecase.*
import br.com.agrotech.web.breed.converter.BreedWebConverter
import br.com.agrotech.web.breed.dto.BreedDTO
import br.com.agrotech.web.breed.dto.request.SaveBreedRequestDTO
import br.com.agrotech.web.breed.dto.response.SaveBreedResponseDTO
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/api/v1/breed")
class BreedController(
    private val saveBreed: SaveBreed,
    private val findBreedById: FindBreedById,
    private val findAllBreeds: FindAllBreeds,
    private val findBreedsBySpeciesId: FindBreedsBySpeciesId,
    private val updateBreed: UpdateBreed,
    private val deleteBreedById: DeleteBreedById,
    private val breedConverter: BreedWebConverter
) {

    @PostMapping("/save")
    fun saveBreed(@RequestBody saveBreedRequestDTO: SaveBreedRequestDTO): ResponseEntity<SaveBreedResponseDTO> {
        val breed = breedConverter.saveBreedRequestDtoToBreed(saveBreedRequestDTO)
        val createdBreed = saveBreed.save(breed)
        return created(URI.create("/api/v1/breed/find/${createdBreed.id.toString()}")).body(breedConverter.breedToSaveBreedResponseDto(createdBreed))
    }

    @GetMapping("/find/all")
    fun findAllBreeds(): ResponseEntity<List<BreedDTO>> {
        val foundBreeds = findAllBreeds.find().map { breedConverter.breedToBreedDto(it) }
        return ok().body(foundBreeds)
    }

    @GetMapping("/find/{breedId}")
    fun findBreed(@PathVariable breedId: String): ResponseEntity<BreedDTO> {
        val foundBreed = breedConverter.breedToBreedDto(findBreedById.find(UUID.fromString(breedId)))
        return ok().body(foundBreed)
    }

    @GetMapping("/find/species/{speciesId}")
    fun findBySpeciesId(@PathVariable speciesId: String): ResponseEntity<List<BreedDTO>> {
        val breedList = findBreedsBySpeciesId.find(UUID.fromString(speciesId)).map { breedConverter.breedToBreedDto(it) }
        return ok().body(breedList)
    }

    @PutMapping("/update/{breedId}")
    fun updateBreed(@PathVariable breedId: String, @RequestBody breedDTO: BreedDTO): ResponseEntity<BreedDTO> {
        val updatedBreed = breedConverter.breedToBreedDto(updateBreed.update(UUID.fromString(breedId), breedConverter.breedDtoToBreed(breedDTO)))
        return ok().body(updatedBreed)
    }

    @DeleteMapping("/delete/{breedId}")
    fun deleteBreedById(@PathVariable breedId: String): ResponseEntity<Unit> {
        deleteBreedById.delete(UUID.fromString(breedId))
        return noContent().build()
    }

}