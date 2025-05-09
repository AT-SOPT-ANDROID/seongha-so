package org.sopt.at.data.remote.service

import org.sopt.at.core.utils.BaseResponse
import org.sopt.at.data.remote.dto.GetMyNicknameResponse
import org.sopt.at.data.remote.dto.LoginRequest
import org.sopt.at.data.remote.dto.LoginResponse
import org.sopt.at.data.remote.dto.SignupRequest
import org.sopt.at.data.remote.dto.SignupResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface UserService {
    @GET("/api/v1/users/me")
    suspend fun getMyNickname(
        @Header("userId") userId: Long
    ): BaseResponse<GetMyNicknameResponse>

}