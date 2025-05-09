package org.sopt.at.feature.onboarding.signup

import androidx.compose.runtime.Immutable

@Immutable
sealed class SignUpAction {
    data class UpdateId(val id: String) : SignUpAction()
    data class UpdatePwd(val pwd: String) : SignUpAction()
    object NextClicked : SignUpAction()
    object ReturnClicked : SignUpAction()
}