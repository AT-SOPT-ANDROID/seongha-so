package org.sopt.at.feature.onboarding.signup

import android.util.Log
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.sopt.at.R
import org.sopt.at.domain.usecase.LoginUseCase
import org.sopt.at.domain.usecase.SignupUseCase
import org.sopt.at.feature.onboarding.login.LoginEvent
import org.sopt.at.core.utils.Result

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signupUseCase: SignupUseCase
): ViewModel() {
    private val _state = MutableStateFlow(SignUpState())
    val state: StateFlow<SignUpState> = _state

    private val _event = Channel<SignUpEvent>()
    val event = _event.receiveAsFlow()

    fun onAction(action: SignUpAction) {
        when (action) {
            is SignUpAction.UpdateId -> {
                val newState = _state.value.copy(id = action.id)
                _state.value = newState.copy(isButtonEnabled = newState.id.isNotBlank())
            }
            is SignUpAction.UpdatePwd -> {
                val newState = _state.value.copy(pwd = action.pwd)
                _state.value = newState.copy(isButtonEnabled = newState.pwd.isNotBlank())
            }
            is SignUpAction.UpdateNickname -> {
                val newState = _state.value.copy(nickname = action.nickname)
                _state.value = newState.copy(isButtonEnabled = newState.nickname.isNotBlank())
            }
            SignUpAction.NextClicked -> {
                when (_state.value.step) {
                    SignUpStep.ID -> {
                        if (idValidCheck(_state.value.id)) {
                            _state.value = _state.value.copy(step = SignUpStep.PASSWORD, isButtonEnabled = _state.value.pwd.isNotBlank())
                        } else {
                            sendEvent(SignUpEvent.ShowToastByInt(R.string.signup_id_not_valid))
                        }
                    }
                    SignUpStep.PASSWORD -> {
                        if (pwdValidCheck(_state.value.pwd)) {
                            _state.value = _state.value.copy(step = SignUpStep.NICKNAME, isButtonEnabled = _state.value.nickname.isNotBlank())
                        } else {
                            sendEvent(SignUpEvent.ShowToastByInt(R.string.signup_pwd_not_valid))
                        }
                    }
                    SignUpStep.NICKNAME -> {
                        if (nicknameValidCheck(_state.value.nickname)) {
                            signup()
                        } else {
                            sendEvent(SignUpEvent.ShowToastByInt(R.string.signup_nickname_not_valid))
                        }
                    }
                }
            }
            SignUpAction.ReturnClicked -> {
                if (_state.value.step == SignUpStep.PASSWORD) {
                    _state.value = _state.value.copy(step = SignUpStep.ID, isButtonEnabled = _state.value.id.isNotBlank())
                }
                else if(_state.value.step == SignUpStep.NICKNAME) {
                    _state.value = _state.value.copy(step = SignUpStep.PASSWORD, isButtonEnabled = _state.value.pwd.isNotBlank())
                }
                else {
                    sendEvent(SignUpEvent.Finish)
                }
            }
        }
    }

    private fun sendEvent(event: SignUpEvent) {
        viewModelScope.launch { _event.send(event) }
    }

    private val idRegex = Regex("^[a-zA-Z0-9]{8,20}\$")
    private val pwdRegex = Regex("^[a-zA-Z0-9]{8,20}\$")
    private val nicknameRegex = Regex("^[가-힣a-zA-Z0-9]{1,20}\$")
    fun idValidCheck(id: String): Boolean{
        return id.matches(idRegex)
    }

    fun pwdValidCheck(pwd: String): Boolean{
        return pwd.matches(pwdRegex)
    }
    fun nicknameValidCheck(nickname: String): Boolean{
        return nickname.matches(nicknameRegex)
    }

    private fun signup() {
        val id = _state.value.id
        val pwd = _state.value.pwd
        val nickname = _state.value.nickname
        viewModelScope.launch {
            val result = signupUseCase(id, pwd, nickname)
            when (result) {
                is Result.Success -> {
                    _event.send(SignUpEvent.Finish)
                }
                is Result.Failure -> {
                    _event.send(SignUpEvent.ShowToastByString(result.message))
                }
                is Result.Error -> {
                    _event.send(SignUpEvent.ShowToastByInt(result.message))
                }
            }
        }
    }
}

@Immutable
sealed class SignUpEvent {
    data class ShowToastByString(val message: String) : SignUpEvent()
    data class ShowToastByInt(val message: Int) : SignUpEvent()
    object Finish : SignUpEvent()
}