package org.sopt.at.domain.usecase

import org.sopt.at.core.utils.Result
import org.sopt.at.domain.entity.Nickname
import org.sopt.at.domain.entity.User
import org.sopt.at.domain.repository.AuthRepository
import org.sopt.at.domain.repository.UserRepository

class GetMyNicknameUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(usrId: Long): Result<Nickname> {
        return repository.getMyNickname(usrId)
    }
}