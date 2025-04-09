package org.sopt.at.feature.onboarding

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class SignupViewModel : ViewModel() {

    var currentStep by mutableStateOf(SignupStep.ID)
        private set
    var textId by mutableStateOf("")
    var textPwd by mutableStateOf("")

    fun nextStep(){
        currentStep = when(currentStep){
            SignupStep.ID -> SignupStep.PASSWORD
            SignupStep.PASSWORD -> SignupStep.PASSWORD
        }
    }

    fun idValidCheck(id: String): Boolean{
        val regex = Regex("^[a-zA-Z0-9]{6,12}\$")
        return id.matches(regex)
    }

    fun pwdValidCheck(pwd: String): Boolean{
        val regex = Regex("^[a-zA-Z0-9~!@#$%^&*]{8,15}\$")
        return pwd.matches(regex)
    }
}