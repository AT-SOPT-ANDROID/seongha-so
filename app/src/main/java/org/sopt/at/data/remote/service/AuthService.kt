package org.sopt.at.data.remote.service

import org.sopt.at.core.utils.BaseResponse
import org.sopt.at.data.remote.dto.LoginRequest
import org.sopt.at.data.remote.dto.LoginResponse
import org.sopt.at.data.remote.dto.SignupRequest
import org.sopt.at.data.remote.dto.SignupResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface AuthService {
    @POST("/api/v1/auth/signup")
    suspend fun signup(
        @Body request: SignupRequest
    ): BaseResponse<SignupResponse>

    @POST("/api/v1/auth/signin")
    suspend fun login(
        @Body request: LoginRequest
    ): BaseResponse<LoginResponse>
}