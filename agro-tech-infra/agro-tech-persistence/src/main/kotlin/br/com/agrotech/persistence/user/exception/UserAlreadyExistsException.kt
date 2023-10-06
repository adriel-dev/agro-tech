package br.com.agrotech.persistence.user.exception

import br.com.agrotech.domain.exception.AlreadyExistsException

class UserAlreadyExistsException(username: String) : AlreadyExistsException("User with username [$username] already exists!")