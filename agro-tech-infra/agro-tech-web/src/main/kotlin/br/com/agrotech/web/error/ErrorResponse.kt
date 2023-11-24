package br.com.agrotech.web.error

import java.time.Instant
import java.time.temporal.ChronoUnit

data class ErrorResponse(
    var status: Int? = null,
    var error: String? = null,
    var message: String? = null,
    var timestamp: Instant? = Instant.now().truncatedTo(ChronoUnit.SECONDS)
)
