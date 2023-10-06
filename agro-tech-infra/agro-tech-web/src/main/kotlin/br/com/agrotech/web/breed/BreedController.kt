package br.com.agrotech.web.breed

import br.com.agrotech.domain.breed.port.api.usecase.SaveBreed
import br.com.agrotech.domain.breed.port.api.usecase.FindBreedById
import br.com.agrotech.domain.breed.port.api.usecase.UpdateBreed
import br.com.agrotech.domain.breed.port.api.usecase.DeleteBreedById
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
    private val updateBreed: UpdateBreed,
    private val deleteBreedById: DeleteBreedById
) {

    @PostMapping("/save")
    fun saveBreed(@RequestBody saveBreedRequestDTO: SaveBreedRequestDTO): ResponseEntity<SaveBreedResponseDTO> {
        val createdBreed = saveBreed.save(saveBreedRequestDTO.toDomainBreed())
        return created(URI.create("/api/v1/breed/find/${createdBreed.id.toString()}")).body(SaveBreedResponseDTO.fromDomainBreed(createdBreed))
    }

    @GetMapping("/find/{breedId}")
    fun findBreed(@PathVariable breedId: String): ResponseEntity<BreedDTO> {
        val foundBreed = BreedDTO.fromDomainBreed(findBreedById.find(UUID.fromString(breedId)))
        return ok().body(foundBreed)
    }

    @PutMapping("/update/{breedId}")
    fun updateBreed(@PathVariable breedId: String, @RequestBody breedDTO: BreedDTO): ResponseEntity<BreedDTO> {
        val updatedBreed = BreedDTO.fromDomainBreed(updateBreed.update(UUID.fromString(breedId), breedDTO.toDomainBreed()))
        return ok().body(updatedBreed)
    }

    @DeleteMapping("/delete/{breedId}")
    fun deleteBreedById(@PathVariable breedId: String): ResponseEntity<Unit> {
        deleteBreedById.delete(UUID.fromString(breedId))
        return noContent().build()
    }

}