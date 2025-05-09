package org.sopt.at.domain.repository

import org.sopt.at.domain.entity.User

interface AuthRepository {
    suspend fun signUp(id: String, pwd: String, nickname: String): org.sopt.at.core.utils.Result<User>
    suspend fun login(id: String, pwd: String): org.sopt.at.core.utils.Result<User>
}