package org.sopt.at.data.repositoryImpl

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.sopt.at.data.remote.dto.LoginRequest
import org.sopt.at.data.remote.dto.SignupRequest
import org.sopt.at.data.remote.service.AuthService
import org.sopt.at.domain.entity.User
import org.sopt.at.domain.repository.AuthRepository


class AuthRepositoryImpl(private val api: AuthService) : AuthRepository {
    override suspend fun login(id: String, pwd: String): org.sopt.at.core.utils.Result<User> =
        withContext(Dispatchers.IO) {
            try {
                val response = api.login(LoginRequest(id, pwd))
                Log.e("AuthRepositoryImpl", response.message)
                org.sopt.at.core.utils.Result.Success(User(response.data?.userId ?: 0))
            } catch (e: Exception) {
                Log.e("AuthRepositoryImpl", "exception!" + e)
                org.sopt.at.core.utils.Result.Error(e)
            }
        }

    override suspend fun signUp(id: String, pwd: String, nickname: String): org.sopt.at.core.utils.Result<User> =
        withContext(Dispatchers.IO) {
            try {
                val response = api.signup(SignupRequest(id, pwd, nickname))
                org.sopt.at.core.utils.Result.Success(User(response.data?.userId ?: 0, response.data?.nickname ?: ""))
            } catch (e: Exception) {
                org.sopt.at.core.utils.Result.Error(e)
            }
        }
}