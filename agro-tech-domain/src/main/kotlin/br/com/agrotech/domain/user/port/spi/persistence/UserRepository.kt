package br.com.agrotech.domain.user.port.spi.persistence

import br.com.agrotech.domain.user.model.User

interface UserRepository {
    fun saveUser(user: User): User
    fun findUserByUsername(username: String): User
}