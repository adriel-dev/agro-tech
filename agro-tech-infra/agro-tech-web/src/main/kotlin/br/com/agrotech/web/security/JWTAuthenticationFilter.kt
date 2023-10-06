package br.com.agrotech.web.security

import br.com.agrotech.persistence.user.repository.UserJpaRepository
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JWTAuthenticationFilter @Autowired constructor(
    private val tokenService: TokenService,
    private val userRepository: UserJpaRepository
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = getTokenFromRequestHeader(request)
        if (token != null) {
            val username = tokenService.validateToken(token)
            val user = userRepository.findByAgroUsername(username)
            val authentication = UsernamePasswordAuthenticationToken(user, null, user.authorities)
            SecurityContextHolder.getContext().authentication = authentication
        }
        filterChain.doFilter(request, response)
    }

    private fun getTokenFromRequestHeader(request: HttpServletRequest): String? {
        return request.getHeader("Authorization")?.replace("Bearer ", "")
    }

}