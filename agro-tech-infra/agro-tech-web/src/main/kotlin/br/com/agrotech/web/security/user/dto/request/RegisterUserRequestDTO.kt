package br.com.agrotech.web.security.user.dto.request

data class RegisterUserRequestDTO(
    val username: String? = null,
    val password: String? = null,
    val rolesIds: List<String>? = null
)