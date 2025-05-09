package org.sopt.at.feature.onboarding.login

import android.util.Log
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.at.R
import org.sopt.at.domain.usecase.LoginUseCase

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel()
{
    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state
    private val _loginEvent = Channel<LoginEvent>()
    val loginEvent = _loginEvent.receiveAsFlow()

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
                login()

//                if () {
//                    viewModelScope.launch {
//                        _loginEvent.send(LoginEvent.NavigateToMain(_state.value.id))
//                    }
//                } else {
//                    viewModelScope.launch {
//                        _loginEvent.send(LoginEvent.ShowSnackbar(R.string.login_not_valid))
//                    }
//                }
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

    private fun login() {
        Log.e("LoginViewModel", "login()")
        val id = _state.value.id
        val pwd = _state.value.pwd
        viewModelScope.launch {
            val result = loginUseCase(id, pwd)
            when (result) {
                is org.sopt.at.core.utils.Result.Success -> {
                    _loginEvent.send(LoginEvent.NavigateToMain(id))
                }

                is org.sopt.at.core.utils.Result.Error -> {
                    _loginEvent.send(LoginEvent.ShowSnackbar(R.string.login_not_valid))
                }
            }
        }
    }

}

@Immutable
sealed class LoginEvent {
    object NavigateToSignUp : LoginEvent()
    data class NavigateToMain(val id: String) : LoginEvent()
    data class ShowSnackbar(val message: Int) : LoginEvent()
}