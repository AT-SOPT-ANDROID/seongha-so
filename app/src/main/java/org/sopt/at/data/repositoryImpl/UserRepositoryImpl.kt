package org.sopt.at.data.repositoryImpl

import com.google.gson.Gson
import java.io.IOException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.sopt.at.R
import org.sopt.at.core.utils.ErrorResponse
import org.sopt.at.core.utils.Result
import org.sopt.at.data.remote.dto.LoginRequest
import org.sopt.at.data.remote.service.AuthService
import org.sopt.at.data.remote.service.UserService
import org.sopt.at.domain.entity.Nickname
import org.sopt.at.domain.entity.User
import org.sopt.at.domain.repository.AuthRepository
import org.sopt.at.domain.repository.UserRepository
import retrofit2.HttpException

class UserRepositoryImpl(private val api: UserService) : UserRepository {
    override suspend fun getMyNickname(userId: Long): Result<Nickname> =
        withContext(Dispatchers.IO) {
            try {
                val response = api.getMyNickname(userId)
                Result.Success(Nickname(response.data?.nickname ?: ""))
            } catch (e: HttpException) {
                val errorBody = e.response()?.errorBody()?.string()
                if (!errorBody.isNullOrEmpty()) {
                    try {
                        val errorResponse = Gson().fromJson(errorBody, ErrorResponse::class.java)
                        Result.Failure(errorResponse.code, errorResponse.message)
                    } catch (e: Exception) {
                        Result.Error(R.string.error_body_parsing_error)
                    }
                } else {
                    Result.Error(R.string.error_body_null_or_empty_error)
                }
            } catch (e: IOException) {
                Result.Error(R.string.unknowable_error)
            }
        }
}