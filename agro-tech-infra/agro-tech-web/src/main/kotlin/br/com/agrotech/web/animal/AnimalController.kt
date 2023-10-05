package br.com.agrotech.web.animal

import br.com.agrotech.domain.animal.port.api.usecase.DeleteAnimalById
import br.com.agrotech.domain.animal.port.api.usecase.FindAnimalById
import br.com.agrotech.domain.animal.port.api.usecase.SaveAnimal
import br.com.agrotech.domain.animal.port.api.usecase.UpdateAnimal
import br.com.agrotech.web.animal.dto.AnimalDTO
import br.com.agrotech.web.animal.dto.request.SaveAnimalRequestDTO
import br.com.agrotech.web.animal.dto.response.SaveAnimalResponseDTO
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/api/v1/animal")
class AnimalController(
    private val saveAnimal: SaveAnimal,
    private val findAnimalById: FindAnimalById,
    private val updateAnimal: UpdateAnimal,
    private val deleteAnimalById: DeleteAnimalById
) {

    @PostMapping("/save")
    fun saveAnimal(@RequestBody saveAnimalRequestDTO: SaveAnimalRequestDTO): ResponseEntity<SaveAnimalResponseDTO> {
        val createdAnimal = saveAnimal.save(saveAnimalRequestDTO.toDomainAnimal())
        return created(URI.create("/api/v1/animal/find/${createdAnimal.id.toString()}")).body((SaveAnimalResponseDTO.fromDomainAnimal(createdAnimal)))
    }

    @GetMapping("/find/{animalId}")
    fun findAnimal(@PathVariable animalId: String): ResponseEntity<AnimalDTO> {
        val foundAnimal = AnimalDTO.fromDomainAnimal(findAnimalById.find(UUID.fromString(animalId)))
        return ok().body(foundAnimal)
    }

    @PutMapping("/update/{animalId}")
    fun updateAnimal(@PathVariable animalId: String, @RequestBody animalDTO: AnimalDTO) : ResponseEntity<AnimalDTO> {
        val updatedAnimal = AnimalDTO.fromDomainAnimal(updateAnimal.update(UUID.fromString(animalId), animalDTO.toDomainAnimal()))
        return ok().body(updatedAnimal)
    }

    @DeleteMapping("/delete/{animalId}")
    fun deleteAnimalById(@PathVariable animalId: String): ResponseEntity<Unit> {
        deleteAnimalById.delete(UUID.fromString(animalId))
        return noContent().build()
    }

}