package org.sopt.at.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SignupRequest(
    @SerializedName("loginId")
    val id: String,
    @SerializedName("password")
    val pwd: String,
    @SerializedName("nickname")
    val nickname: String
)


data class SignupResponse(
    @SerializedName("userId")
    val userId: Long,
    @SerializedName("nickname")
    val nickname: String
)

data class LoginRequest(
    @SerializedName("loginId")
    val id: String,
    @SerializedName("password")
    val pwd: String
)


data class LoginResponse(
    @SerializedName("userId")
    val userId: Long
)