package br.com.agrotech.web.animal.facade

import br.com.agrotech.domain.pagination.DomainPage
import br.com.agrotech.web.animal.dto.AnimalDTO
import br.com.agrotech.web.animal.dto.request.SaveAnimalRequestDTO
import br.com.agrotech.web.animal.dto.response.FindAnimalByIdResponseDTO
import br.com.agrotech.web.animal.dto.response.SaveAnimalResponseDTO
import org.springframework.data.domain.Page
import org.springframework.security.core.Authentication
import org.springframework.web.multipart.MultipartFile
import java.util.UUID

interface AnimalFacade {
    fun saveAnimal(saveAnimalRequestDTO: SaveAnimalRequestDTO, imageFile: MultipartFile?): SaveAnimalResponseDTO
    fun findAnimalById(animalId: UUID): FindAnimalByIdResponseDTO
    fun findAllAnimals(authentication: Authentication, page: Int, size: Int): DomainPage<AnimalDTO>
    fun updateAnimal(animalId: UUID, animalDto: AnimalDTO): AnimalDTO
    fun deleteAnimalById(animalId: UUID)
}