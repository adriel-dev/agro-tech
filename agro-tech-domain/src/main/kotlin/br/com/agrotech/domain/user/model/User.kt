package br.com.agrotech.domain.user.model

import br.com.agrotech.domain.farm.model.Farm
import java.util.*

data class User(
    var id: UUID? = null,
    var username: String? = null,
    var password: String? = null,
    var email: String? = null,
    var farm: Farm? = null,
    var roles: MutableSet<Role>? = null
)

data class Role(
    var id: UUID? = null,
    var name: String? = null
)