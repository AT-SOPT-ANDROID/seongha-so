package org.sopt.at.feature.onboarding

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

    fun idValidCheck(id: String): Boolean{
        val regex = Regex("^[a-zA-Z0-9]{6,12}\$")
        return id.matches(regex)
    }

    fun pwdValidCheck(pwd: String): Boolean{
        val regex = Regex("^[a-zA-Z0-9~!@#$%^&*]{8,15}\$")
        return pwd.matches(regex)
    }
}