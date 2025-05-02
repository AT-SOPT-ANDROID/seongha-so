package org.sopt.at.feature.onboarding.login

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state
    private val _loginEvent = Channel<LoginEvent>()
    val loginEvent = _loginEvent.receiveAsFlow()

    var getId: String = ""
    var getPwd: String = ""

    fun onAction(action: LoginAction) {
        when (action) {
            is LoginAction.UpdateId -> {
                val newState = _state.value.copy(id = action.id)
                _state.value = newState.copy(isButtonEnabled = checkButtonValid(newState))
            }
            is LoginAction.UpdatePwd -> {
                val newState = _state.value.copy(pwd = action.pwd)
                _state.value = newState.copy(isButtonEnabled = checkButtonValid(newState))
            }
            LoginAction.LoginClicked -> {
                if (loginValidCheck()) {
                    viewModelScope.launch {
                        _loginEvent.send(LoginEvent.NavigateToMain(_state.value.id))
                    }
                } else {
                    viewModelScope.launch {
                        _loginEvent.send(LoginEvent.ShowSnackbar("아이디 또는 비밀번호가 유효하지 않습니다."))
                    }
                }
            }
            LoginAction.SignupClicked -> {
                viewModelScope.launch {
                    _loginEvent.send(LoginEvent.NavigateToSignUp)
                }
            }
        }
    }

    private fun checkButtonValid(state: LoginState): Boolean =
        state.id.isNotBlank() && state.pwd.isNotBlank()

    fun loginValidCheck(): Boolean =
        _state.value.id == getId && _state.value.pwd == getPwd
}

@Immutable
sealed class LoginEvent {
    object NavigateToSignUp : LoginEvent()
    data class NavigateToMain(val id: String) : LoginEvent()
    data class ShowSnackbar(val message: String) : LoginEvent()
}