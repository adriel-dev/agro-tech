package br.com.agrotech.web.error

enum class ErrorsEnum(private val error: String) {
    BAD_REQUEST("Bad Request"),
    NOT_FOUND("Not Found"),
    INTERNAL_SERVER_ERROR("Internal Server Error");

    override fun toString(): String {
        return error
    }
}