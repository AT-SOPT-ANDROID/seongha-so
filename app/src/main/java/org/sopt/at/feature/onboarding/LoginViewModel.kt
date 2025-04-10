package org.sopt.at.feature.onboarding

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var getId by mutableStateOf("")
    var getPwd by mutableStateOf("")
    var textId by mutableStateOf("")
    var textPwd by mutableStateOf("")

    fun loginValidCheck(): Boolean{
        return getId == textId && getPwd == textPwd
    }
}