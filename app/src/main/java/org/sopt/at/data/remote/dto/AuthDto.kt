package org.sopt.at.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class SignupRequest(
    @SerialName("loginId")
    val id: String,
    @SerialName("password")
    val pwd: String,
    @SerialName("nickname")
    val nickname: String
)


@kotlinx.serialization.Serializable
data class SignupResponse(
    @SerialName("userId")
    val userId: Long,
    @SerialName("nickname")
    val nickname: String
)

@kotlinx.serialization.Serializable
data class LoginRequest(
    @SerialName("loginId")
    val id: String,
    @SerialName("password")
    val pwd: String
)


@kotlinx.serialization.Serializable
data class LoginResponse(
    @SerialName("userId")
    val userId: Long
)