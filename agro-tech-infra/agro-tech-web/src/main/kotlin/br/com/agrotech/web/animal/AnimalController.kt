package br.com.agrotech.web.animal

import br.com.agrotech.web.animal.dto.AnimalDTO
import br.com.agrotech.web.animal.dto.request.SaveAnimalRequestDTO
import br.com.agrotech.web.animal.dto.response.FindAnimalByIdResponseDTO
import br.com.agrotech.web.animal.dto.response.SaveAnimalResponseDTO
import br.com.agrotech.web.animal.facade.AnimalFacade
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
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
    fun saveAnimal(@RequestPart("data") saveAnimalRequestDTO: SaveAnimalRequestDTO, @RequestPart(value = "image", required = false) imageFile: MultipartFile?): ResponseEntity<SaveAnimalResponseDTO> {
        val createdAnimal = animalFacade.saveAnimal(saveAnimalRequestDTO = saveAnimalRequestDTO, imageFile = imageFile)
        return created(URI.create("/api/v1/animal/find/${createdAnimal.id.toString()}")).body(createdAnimal)
    }

    @GetMapping("/find/{animalId}")
    fun findAnimal(@PathVariable animalId: String): ResponseEntity<FindAnimalByIdResponseDTO> {
        val foundAnimal = animalFacade.findAnimalById(UUID.fromString(animalId))
        return ok().body(foundAnimal)
    }

    @PutMapping("/update/{animalId}")
    fun updateAnimal(@PathVariable animalId: String, @RequestBody animalDTO: AnimalDTO) : ResponseEntity<AnimalDTO> {
        val updatedAnimal = animalFacade.updateAnimal(UUID.fromString(animalId), animalDTO)
        return ok().body(updatedAnimal)
    }

    @DeleteMapping("/delete/{animalId}")
    fun deleteAnimalById(@PathVariable animalId: String): ResponseEntity<Unit> {
        animalFacade.deleteAnimalById(UUID.fromString(animalId))
        return noContent().build()
    }

}