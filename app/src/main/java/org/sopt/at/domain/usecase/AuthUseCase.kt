package org.sopt.at.domain.usecase

import android.util.Log
import org.sopt.at.core.utils.Result
import org.sopt.at.domain.entity.User
import org.sopt.at.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(id: String, pwd: String): Result<User> {
        Log.e("LoginUseCase", "invoke()")
        return repository.login(id, pwd)
    }
}

class SignupUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(id: String, pwd: String, nickname: String): Result<User> {
        return repository.signUp(id, pwd, nickname)
    }
}