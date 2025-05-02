package org.sopt.at.feature.onboarding.signup

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class SignUpViewModel : ViewModel() {

    var currentStep by mutableStateOf(SignUpStep.ID)
        private set
    var textId by mutableStateOf("")
    var textPwd by mutableStateOf("")

    fun nextStep(){
        currentStep = when(currentStep){
            SignUpStep.ID -> SignUpStep.PASSWORD
            SignUpStep.PASSWORD -> SignUpStep.PASSWORD
        }
    }

    fun previewStep(){
        currentStep = when(currentStep){
            SignUpStep.ID -> SignUpStep.ID
            SignUpStep.PASSWORD -> SignUpStep.ID
        }
    }

    private val idRegex = Regex("^[a-zA-Z0-9]{6,12}\$")
    private val pwdRegex = Regex("^[a-zA-Z0-9~!@#$%^&*]{8,15}\$")
    fun idValidCheck(id: String): Boolean{
        return id.matches(idRegex)
    }

    fun pwdValidCheck(pwd: String): Boolean{
        return pwd.matches(pwdRegex)
    }
}