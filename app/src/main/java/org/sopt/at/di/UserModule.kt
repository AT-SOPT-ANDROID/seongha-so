package org.sopt.at.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton
import org.sopt.at.data.remote.service.AuthService
import org.sopt.at.data.remote.service.UserService
import org.sopt.at.data.repositoryImpl.AuthRepositoryImpl
import org.sopt.at.data.repositoryImpl.UserRepositoryImpl
import org.sopt.at.domain.repository.AuthRepository
import org.sopt.at.domain.repository.UserRepository
import org.sopt.at.domain.usecase.GetMyNicknameUseCase
import org.sopt.at.domain.usecase.LoginUseCase
import org.sopt.at.domain.usecase.SignupUseCase
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object UserModule {
    @Provides
    fun provideUserRepository(userService: UserService): UserRepository {
        return UserRepositoryImpl(userService)
    }

    @Provides
    fun provideGetMyNicknameUseCase(repository: UserRepository): GetMyNicknameUseCase {
        return GetMyNicknameUseCase(repository)
    }
}