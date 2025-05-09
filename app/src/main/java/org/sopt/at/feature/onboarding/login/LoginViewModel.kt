package org.sopt.at.feature.onboarding.login

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.sopt.at.R
import org.sopt.at.core.utils.Result
import org.sopt.at.domain.usecase.LoginUseCase
import org.sopt.at.feature.onboarding.signup.SignUpEvent

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel()
{
    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state
    private val _event = Channel<LoginEvent>()
    val event = _event.receiveAsFlow()

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
                    _event.send(LoginEvent.NavigateToSignUp)
                }
            }
        }
    }

    private fun checkButtonValid(state: LoginState): Boolean =
        state.id.isNotBlank() && state.pwd.isNotBlank()

    private fun login() {
        val id = _state.value.id
        val pwd = _state.value.pwd
        viewModelScope.launch {
            val result = loginUseCase(id, pwd)
            when (result) {
                is Result.Success -> {
                    _event.send(LoginEvent.NavigateToMain(result.data.userId))
                }
                is Result.Failure -> {
                    _event.send(LoginEvent.ShowSnackbarByString(result.message))
                }
                is Result.Error -> {
                    _event.send(LoginEvent.ShowSnackbarByInt(result.message))
                }
            }
        }
    }

}

@Immutable
sealed class LoginEvent {
    object NavigateToSignUp : LoginEvent()
    data class NavigateToMain(val userId: Long) : LoginEvent()
    data class ShowSnackbarByInt(val message: Int) : LoginEvent()
    data class ShowSnackbarByString(val message: String) : LoginEvent()
}