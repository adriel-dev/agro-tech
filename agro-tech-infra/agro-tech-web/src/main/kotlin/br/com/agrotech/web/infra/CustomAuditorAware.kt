package br.com.agrotech.web.infra

import org.springframework.data.domain.AuditorAware
import org.springframework.security.core.context.SecurityContextHolder
import java.util.*


class CustomAuditorAware : AuditorAware<String> {

    override fun getCurrentAuditor(): Optional<String> {
        val userName = SecurityContextHolder.getContext().authentication.name
        return Optional.ofNullable(userName)
    }

}