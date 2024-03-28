package br.com.agrotech.web.security

import br.com.agrotech.persistence.user.entity.UserEntity
import br.com.agrotech.web.security.exception.JwtGenerateException
import br.com.agrotech.web.security.exception.JwtTokenExpiredException
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTCreationException
import com.auth0.jwt.exceptions.JWTVerificationException
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

@Service
class TokenService(
    @Value("\${api.security.token.secret}")
    private val jwtSecret: String,
    @Value("\${spring.application.name}")
    private val appName: String
) {

    fun generateToken(user: UserEntity): String {
        try {
            val algorithm = Algorithm.HMAC256(jwtSecret)
            return JWT.create()
                .withIssuer(appName)
                .withSubject(user.agroUsername)
                .withExpiresAt(generateExpirationDate())
                .withClaim("farmId", user.farm?.id.toString())
                .sign(algorithm)
        } catch (e: JWTCreationException) {
            throw JwtGenerateException("Error generating JWT token!")
        }
    }

    fun validateToken(token: String?): String {
        return try {
            val algorithm = Algorithm.HMAC256(jwtSecret)
            JWT.require(algorithm)
                .withIssuer(appName)
                .build()
                .verify(token)
                .subject
        } catch (e: JWTVerificationException) {
            throw JwtTokenExpiredException(e.message!!)
        }
    }

    private fun generateExpirationDate(): Instant {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"))
    }

}