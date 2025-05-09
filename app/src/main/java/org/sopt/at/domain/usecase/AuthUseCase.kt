package org.sopt.at.domain.usecase

import org.sopt.at.core.utils.Result
import org.sopt.at.domain.entity.User
import org.sopt.at.domain.repository.AuthRepository

class LoginUsecase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Result<User> {
        return repository.login(email, password)
    }
}