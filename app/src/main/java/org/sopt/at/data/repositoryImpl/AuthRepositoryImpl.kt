package org.sopt.at.data.repositoryImpl

import android.util.Log
import com.google.gson.Gson
import java.io.IOException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.sopt.at.R
import org.sopt.at.core.utils.ErrorResponse
import org.sopt.at.data.remote.dto.LoginRequest
import org.sopt.at.data.remote.dto.SignupRequest
import org.sopt.at.data.remote.service.AuthService
import org.sopt.at.domain.entity.User
import org.sopt.at.domain.repository.AuthRepository
import org.sopt.at.core.utils.Result
import retrofit2.HttpException


class AuthRepositoryImpl(private val api: AuthService) : AuthRepository {
    override suspend fun login(id: String, pwd: String): Result<User> =
        withContext(Dispatchers.IO) {
            try {
                val response = api.login(LoginRequest(id, pwd))
                Result.Success(User(response.data?.userId ?: 0))
            }
            catch (e: HttpException) {
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
            }
            catch (e: IOException) {
                Result.Error(R.string.unknowable_error)
            }
        }

    override suspend fun signUp(id: String, pwd: String, nickname: String): Result<User> =
        withContext(Dispatchers.IO) {
            try {
                val response = api.signup(SignupRequest(id, pwd, nickname))
                Result.Success(User(response.data?.userId ?: 0, response.data?.nickname ?: ""))
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
            }
            catch (e: IOException) {
                Result.Error(R.string.unknowable_error)
            }
        }
}