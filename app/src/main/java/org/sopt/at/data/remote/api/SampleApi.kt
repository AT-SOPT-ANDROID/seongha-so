package org.sopt.at.data.remote.api

import org.sopt.at.data.remote.dto.ResponseSingleUserDto
import org.sopt.at.data.remote.dto.ResponseUserListDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserService {
    @GET("/api/users/{userId}")
    fun getSingleUser(
        @Path("userId") userId: Int
    ): Call<ResponseSingleUserDto>

    @GET("/api/users")
    fun getUserList(
        @Query("page") page: Int
    ): Call<ResponseUserListDto>
}