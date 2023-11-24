package br.com.agrotech.web.security.exception

import br.com.agrotech.domain.exception.AgroTechException

class JwtTokenExpiredException(message: String) : AgroTechException(message)