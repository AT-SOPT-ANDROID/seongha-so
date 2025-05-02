package org.sopt.at.feature.onboarding.login

import androidx.compose.runtime.Immutable

@Immutable
data class LoginState(
    val id: String = "",
    val pwd: String = "",
    val isButtonEnabled: Boolean = false
)