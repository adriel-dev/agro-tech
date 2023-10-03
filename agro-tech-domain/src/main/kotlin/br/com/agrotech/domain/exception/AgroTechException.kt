package br.com.agrotech.domain.exception

open class AgroTechException : RuntimeException {

    constructor()
    constructor(message: String): super(message)

}