package br.com.agrotech.web.security

import br.com.agrotech.persistence.user.entity.UserEntity
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
                .sign(algorithm)
        } catch (e: JWTCreationException) {
            throw RuntimeException("Error generating JWT token!", e)
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
            ""
        }
    }

    private fun generateExpirationDate(): Instant {
        return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"))
    }

}