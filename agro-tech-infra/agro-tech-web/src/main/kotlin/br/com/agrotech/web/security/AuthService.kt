package br.com.agrotech.web.security

import br.com.agrotech.domain.user.model.User
import br.com.agrotech.domain.user.port.api.usecase.FindRoleByName
import br.com.agrotech.domain.user.port.api.usecase.RegisterFirstUser
import br.com.agrotech.domain.user.port.api.usecase.RegisterUser
import br.com.agrotech.persistence.farm.entity.FarmEntity
import br.com.agrotech.persistence.user.converter.UserPersistenceConverter
import br.com.agrotech.persistence.user.entity.RoleEntity
import br.com.agrotech.persistence.user.entity.UserEntity
import br.com.agrotech.web.farm.converter.FarmWebConverter
import br.com.agrotech.web.security.dto.LoginRequestDTO
import br.com.agrotech.web.security.dto.LoginResponseDTO
import br.com.agrotech.web.user.dto.request.RegisterFirstUserRequestDTO
import br.com.agrotech.web.user.dto.request.RegisterUserRequestDTO
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthService(
    private val authenticationManager: AuthenticationManager,
    private val tokenService: TokenService,
    private val registerUser: RegisterUser,
    private val registerFirstUser: RegisterFirstUser,
    private val findRoleByName: FindRoleByName,
    private val farmConverter: FarmWebConverter,
    private val userConverter: UserPersistenceConverter
) {

    fun login(loginData: LoginRequestDTO): LoginResponseDTO {
        val usernamePassword = UsernamePasswordAuthenticationToken(loginData.username, loginData.password)
        val auth = this.authenticationManager.authenticate(usernamePassword)
        val token = tokenService.generateToken(auth.principal as UserEntity)
        return LoginResponseDTO(token)
    }

    fun register(registerData: RegisterUserRequestDTO) {
        val user = buildUserWithData(registerData)
        registerUser.register(user)
    }

    fun registerFirstUser(registerData: RegisterFirstUserRequestDTO) {
        val role = findRoleByName.find("ROLE_OWNER")
        val user = buildUserWithData(
            RegisterUserRequestDTO(
            username = registerData.userData?.username,
            password = registerData.userData?.password,
            email = registerData.userData?.email,
            farmId = UUID.randomUUID().toString(),
            rolesIds = listOf(role.id.toString())
        )
        )
        registerFirstUser.register(
            farm = farmConverter.saveFirstFarmRequestDtoToFarm(registerData.farmData!!),
            user = user
        )
    }

    private fun buildUserWithData(registerData: RegisterUserRequestDTO): User {
        val encryptedPassword = BCryptPasswordEncoder().encode(registerData.password)
        val roles = registerData.rolesIds?.map { roleId -> RoleEntity(id = UUID.fromString(roleId)) }?.toMutableSet()
        val newUser = UserEntity(agroUsername = registerData.username, agroPassword = encryptedPassword, email = registerData.email,
            farm = FarmEntity(id = UUID.fromString(registerData.farmId)), roles = roles)
        return userConverter.userEntityToUser(newUser)
    }

}