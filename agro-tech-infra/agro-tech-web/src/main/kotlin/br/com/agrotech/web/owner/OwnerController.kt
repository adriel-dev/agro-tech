package br.com.agrotech.web.owner

import br.com.agrotech.domain.owner.port.api.usecase.SaveOwner
import br.com.agrotech.domain.owner.port.api.usecase.FindOwnerById
import br.com.agrotech.domain.owner.port.api.usecase.UpdateOwner
import br.com.agrotech.domain.owner.port.api.usecase.DeleteOwnerById
import br.com.agrotech.web.owner.dto.OwnerDTO
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/api/v1/owner")
class OwnerController(
    private val saveOwner: SaveOwner,
    private val findOwnerById: FindOwnerById,
    private val updateOwner: UpdateOwner,
    private val deleteOwnerById: DeleteOwnerById
) {

    @PostMapping("/save")
    fun saveOwner(@RequestBody ownerDTO: OwnerDTO): ResponseEntity<OwnerDTO> {
        val createdOwner = saveOwner.save(ownerDTO.toDomainOwner())
        return created(URI.create("/api/v1/owner/find/${createdOwner.id.toString()}")).body(OwnerDTO.fromDomainOwner(createdOwner))
    }

    @GetMapping("/find/{ownerId}")
    fun findOwner(@PathVariable ownerId: String): ResponseEntity<OwnerDTO> {
        val foundOwner = OwnerDTO.fromDomainOwner(findOwnerById.find(UUID.fromString(ownerId)))
        return ok().body(foundOwner)
    }

    @PutMapping("/update/{ownerId}")
    fun updateOwner(@PathVariable ownerId: String, @RequestBody ownerDTO: OwnerDTO): ResponseEntity<OwnerDTO> {
        val updatedOwner = OwnerDTO.fromDomainOwner(updateOwner.update(UUID.fromString(ownerId), ownerDTO.toDomainOwner()))
        return ok().body(updatedOwner)
    }

    @DeleteMapping("/delete/{ownerId}")
    fun deleteOwnerById(@PathVariable ownerId: String): ResponseEntity<Unit> {
        deleteOwnerById.delete(UUID.fromString(ownerId))
        return noContent().build()
    }
}
