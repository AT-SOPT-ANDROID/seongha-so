package org.sopt.at.core.utils

sealed class Result<out T> {
    data class Success<out T>(val data: T): Result<T>()
    data class Failure(val code: String, val message: String): Result<Nothing>()
    data class Error(val message: Int): Result<Nothing>()
}