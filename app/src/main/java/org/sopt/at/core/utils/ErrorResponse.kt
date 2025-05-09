package org.sopt.at.core.utils

data class ErrorResponse(
    val success: Boolean,
    val code: String,
    val message: String
)