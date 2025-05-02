package org.sopt.at.feature.onboarding.login

data class LoginState(
    val id: String = "",
    val pwd: String = "",
    val isButtonEnabled: Boolean = false
)