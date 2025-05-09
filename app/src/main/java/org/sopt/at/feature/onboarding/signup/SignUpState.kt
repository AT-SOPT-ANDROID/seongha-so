package org.sopt.at.feature.onboarding.signup

import androidx.compose.runtime.Immutable

@Immutable
data class SignUpState (
    val step: SignUpStep = SignUpStep.ID,
    val id: String = "",
    val pwd: String = "",
    val nickname: String = "",
    val isButtonEnabled: Boolean = false
)