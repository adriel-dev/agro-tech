package br.com.agrotech.web.security

import br.com.agrotech.web.security.dto.LoginRequestDTO
import br.com.agrotech.web.security.dto.LoginResponseDTO
import br.com.agrotech.web.user.dto.request.RegisterFirstUserRequestDTO
import br.com.agrotech.web.user.dto.request.RegisterUserRequestDTO
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(
    private val authService: AuthService
) {

    @PostMapping("/login")
    fun login(@RequestBody loginData: LoginRequestDTO): ResponseEntity<LoginResponseDTO> {
        return ok().body(authService.login(loginData))
    }

    @PostMapping("/register")
    fun register(@Valid @RequestBody registerData: RegisterUserRequestDTO): ResponseEntity<Unit> {
        authService.register(registerData)
        return ok().build()
    }

    @PostMapping("/register/first")
    fun registerFirstUser(@RequestBody registerData: RegisterFirstUserRequestDTO): ResponseEntity<Unit> {
        authService.registerFirstUser(registerData)
        return ok().build()
    }

}