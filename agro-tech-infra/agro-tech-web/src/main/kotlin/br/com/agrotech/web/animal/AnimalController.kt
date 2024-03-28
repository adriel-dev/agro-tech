package br.com.agrotech.web.animal

import br.com.agrotech.domain.pagination.DomainPage
import br.com.agrotech.web.animal.dto.AnimalDTO
import br.com.agrotech.web.animal.dto.request.SaveAnimalRequestDTO
import br.com.agrotech.web.animal.dto.response.FindAllAnimalsResponseDTO
import br.com.agrotech.web.animal.dto.response.FindAnimalByIdResponseDTO
import br.com.agrotech.web.animal.dto.response.SaveAnimalResponseDTO
import br.com.agrotech.web.animal.facade.AnimalFacade
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.PositiveOrZero
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/api/v1/animal")
class AnimalController(
    private val animalFacade: AnimalFacade
) {

    @PostMapping("/save")
    fun saveAnimal(@RequestPart("data") saveAnimalRequestDTO: SaveAnimalRequestDTO, @RequestPart("image", required = false) imageFile: MultipartFile?): ResponseEntity<SaveAnimalResponseDTO> {
        val createdAnimal = animalFacade.saveAnimal(saveAnimalRequestDTO = saveAnimalRequestDTO, imageFile = imageFile)
        return created(URI.create("/api/v1/animal/find/${createdAnimal.id.toString()}")).body(createdAnimal)
    }

    @GetMapping("/find/{animalId}")
    fun findAnimal(@PathVariable animalId: String): ResponseEntity<FindAnimalByIdResponseDTO> {
        val foundAnimal = animalFacade.findAnimalById(UUID.fromString(animalId))
        return ok().body(foundAnimal)
    }

    @GetMapping("/find/all")
    fun findAll(
        @RequestParam(defaultValue = "0") @PositiveOrZero page: Int,
        @RequestParam(defaultValue = "10") @Positive @Max(100) size: Int,
        @RequestParam(required = false) breedsIds: List<String>?,
        @RequestParam(required = false) animalName: String?,
        @RequestParam(required = false) externalId: String?,
        authentication: Authentication)
    : ResponseEntity<DomainPage<FindAllAnimalsResponseDTO>> {
        println("Breed Ids: $breedsIds")
        println("Animal Name: $animalName")
        println("Animal Id: $externalId")
        val breedsIdsUuid = breedsIds?.map { UUID.fromString(it) }
        return ok().body(animalFacade.findAllAnimals(authentication, page, size, breedsIdsUuid, animalName, externalId))
    }

    @PutMapping("/update/{animalId}")
    fun updateAnimal(@PathVariable animalId: String, @RequestPart("data") animalDTO: AnimalDTO, @RequestPart("image", required = false) imageFile: MultipartFile?) : ResponseEntity<AnimalDTO> {
        val updatedAnimal = animalFacade.updateAnimal(UUID.fromString(animalId), animalDTO, imageFile)
        return ok().body(updatedAnimal)
    }

    @DeleteMapping("/delete/{animalId}")
    fun deleteAnimalById(@PathVariable animalId: String): ResponseEntity<Unit> {
        animalFacade.deleteAnimalById(UUID.fromString(animalId))
        return noContent().build()
    }

}