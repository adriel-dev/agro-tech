package br.com.agrotech.web.animal.facade

import br.com.agrotech.domain.pagination.DomainPage
import br.com.agrotech.web.animal.dto.AnimalDTO
import br.com.agrotech.web.animal.dto.request.SaveAnimalRequestDTO
import br.com.agrotech.web.animal.dto.response.FindAllAnimalsResponseDTO
import br.com.agrotech.web.animal.dto.response.FindAnimalByIdResponseDTO
import br.com.agrotech.web.animal.dto.response.SaveAnimalResponseDTO
import org.springframework.security.core.Authentication
import org.springframework.web.multipart.MultipartFile
import java.util.UUID

interface AnimalFacade {
    fun saveAnimal(saveAnimalRequestDTO: SaveAnimalRequestDTO, imageFile: MultipartFile?): SaveAnimalResponseDTO
    fun findAnimalById(animalId: UUID): FindAnimalByIdResponseDTO
    fun findAllAnimals(
        authentication: Authentication, page: Int, size: Int,
        speciesIds: List<UUID>?, animalName: String?, externalId: String?
    ): DomainPage<FindAllAnimalsResponseDTO>
    fun updateAnimal(animalId: UUID, animalDto: AnimalDTO, imageFile: MultipartFile?): AnimalDTO
    fun deleteAnimalById(animalId: UUID)
}