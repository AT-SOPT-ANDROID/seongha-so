package org.sopt.at.core.utils

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Response<T>(
    @SerialName("success")
    val success: Boolean,
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: T?
)