package org.sopt.at.domain.repository

import org.sopt.at.domain.entity.User
import org.sopt.at.core.utils.Result
import org.sopt.at.domain.entity.Nickname

interface UserRepository {
    suspend fun getMyNickname(userId: Long): Result<Nickname>
}