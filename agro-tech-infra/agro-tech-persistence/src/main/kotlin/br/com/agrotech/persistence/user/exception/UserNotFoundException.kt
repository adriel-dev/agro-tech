package br.com.agrotech.persistence.user.exception

import br.com.agrotech.domain.exception.NotFoundException

class UserNotFoundException(username: String) : NotFoundException("User with username [$username] was not found!")