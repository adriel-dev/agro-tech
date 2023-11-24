package br.com.agrotech.web.security.dto

data class LoginRequestDTO(
    val username: String? = null,
    val password: String? = null
)