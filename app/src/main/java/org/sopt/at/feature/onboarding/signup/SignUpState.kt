package org.sopt.at.feature.onboarding.signup

data class SignUpState (
    val step: SignUpStep = SignUpStep.ID,
    val id: String = "",
    val pwd: String = "",
    val isButtonEnabled: Boolean = false
)