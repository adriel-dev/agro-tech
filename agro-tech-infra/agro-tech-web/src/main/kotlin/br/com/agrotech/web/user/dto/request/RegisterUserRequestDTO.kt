package br.com.agrotech.web.user.dto.request

data class RegisterUserRequestDTO(
    val username: String? = null,
    val password: String? = null,
    val email: String? = null,
    val farmId: String? = null,
    val rolesIds: List<String>? = null
)

data class RegisterFirstUserDataRequestDTO(
    val username: String? = null,
    val password: String? = null,
    val email: String? = null
)