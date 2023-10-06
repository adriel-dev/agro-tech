package br.com.agrotech.domain.user.model

import java.util.*

data class User(
    var id: UUID? = null,
    var agroUsername: String? = null,
    var agroPassword: String? = null,
    var roles: MutableSet<Role>? = null
)

data class Role(
    var id: UUID? = null,
    var name: String? = null
)