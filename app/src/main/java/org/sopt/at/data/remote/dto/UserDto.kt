package org.sopt.at.data.remote.dto

import com.google.gson.annotations.SerializedName

data class GetMyNicknameResponse(
    @SerializedName("nickname")
    val nickname: String
)