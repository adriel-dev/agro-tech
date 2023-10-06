package br.com.agrotech.web.security.user.service

import br.com.agrotech.domain.user.port.api.usecase.RegisterUser
import br.com.agrotech.persistence.user.entity.RoleEntity
import br.com.agrotech.persistence.user.entity.UserEntity
import br.com.agrotech.web.security.TokenService
import br.com.agrotech.web.security.dto.LoginRequestDTO
import br.com.agrotech.web.security.dto.LoginResponseDTO
import br.com.agrotech.web.security.user.dto.request.RegisterUserRequestDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthService @Autowired constructor(
    private val authenticationManager: AuthenticationManager,
    private val tokenService: TokenService,
    private val registerUser: RegisterUser
) {

    fun login(loginData: LoginRequestDTO): LoginResponseDTO {
        val usernamePassword = UsernamePasswordAuthenticationToken(loginData.username, loginData.password)
        val auth = this.authenticationManager.authenticate(usernamePassword)
        val token = tokenService.generateToken(auth.principal as UserEntity)
        return LoginResponseDTO(token)
    }

    fun register(registerData: RegisterUserRequestDTO) {
        val encryptedPassword = BCryptPasswordEncoder().encode(registerData.password)
        val roles = registerData.rolesIds?.map { roleId -> RoleEntity(id = UUID.fromString(roleId)) }?.toMutableSet()
        val newUser = UserEntity(agroUsername = registerData.username, agroPassword = encryptedPassword, roles = roles)
        registerUser.register(newUser.toDomainUser())
    }

}