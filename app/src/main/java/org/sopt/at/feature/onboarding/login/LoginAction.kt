package org.sopt.at.feature.onboarding.login

sealed class LoginAction {
    data class UpdateId(val id: String) : LoginAction()
    data class UpdatePwd(val pwd: String) : LoginAction()
    object LoginClicked : LoginAction()
    object SignupClicked : LoginAction()
}