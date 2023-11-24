package br.com.agrotech.persistence.user.repository

import br.com.agrotech.persistence.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface UserJpaRepository : JpaRepository<UserEntity,UUID> {
    fun findByAgroUsername(username: String): Optional<UserEntity>
}