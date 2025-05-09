package org.sopt.at.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import org.sopt.at.data.remote.service.AuthService
import org.sopt.at.data.repositoryImpl.AuthRepositoryImpl
import org.sopt.at.domain.repository.AuthRepository
import org.sopt.at.domain.usecase.LoginUseCase
import org.sopt.at.domain.usecase.SignupUseCase

@Module
@InstallIn(ViewModelComponent::class)
object AuthModule {

    @Provides
    fun provideAuthRepository(authService: AuthService): AuthRepository {
        return AuthRepositoryImpl(authService)
    }

    @Provides
    fun provideLoginUseCase(repository: AuthRepository): LoginUseCase {
        return LoginUseCase(repository)
    }

    @Provides
    fun provideSignupUseCase(repository: AuthRepository): SignupUseCase {
        return SignupUseCase(repository)
    }
}