package br.com.agrotech.web.animal

import br.com.agrotech.persistence.animal.exception.AnimalNotFoundException
import br.com.agrotech.persistence.animal.repository.AnimalJpaRepository
import br.com.agrotech.persistence.user.entity.UserEntity
import br.com.agrotech.web.animal.dto.request.SaveAnimalRequestDTO
import br.com.agrotech.web.animal.dto.response.FindAnimalByIdResponseDTO
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*

@Component
class AnimalPermissionEvaluator(
    private val animalJpaRepository: AnimalJpaRepository
) {

    fun hasPermissionToSave(authentication: Authentication, animalRequest: SaveAnimalRequestDTO): Boolean {
        val user = authentication.principal as UserEntity
        val farmId = animalRequest.farmId
        return user.farm?.id == UUID.fromString(farmId)
    }

    fun hasPermissionToGet(authentication: Authentication, animal: FindAnimalByIdResponseDTO): Boolean {
        val user = authentication.principal as UserEntity
        return user.farm?.id == animal.farm?.id
    }

    fun hasPermissionToUpdateOrDelete(authentication: Authentication, animalId: String): Boolean {
        val animalUUID = UUID.fromString(animalId)
        val user = authentication.principal as UserEntity
        val animal = animalJpaRepository.findById(animalUUID).orElseThrow { AnimalNotFoundException(animalUUID) }
        val farmId = animal.farm?.id
        return user.farm?.id == farmId
    }

}