package org.sopt.at.feature.onboarding.signup

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.sopt.at.R

@Stable
class SignUpViewModel : ViewModel() {
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
                            sendEvent(SignUpEvent.ShowToast(R.string.signup_id_not_valid))
                        }
                    }
                    SignUpStep.PASSWORD -> {
                        if (pwdValidCheck(_state.value.pwd)) {
                            _state.value = _state.value.copy(step = SignUpStep.NICKNAME, isButtonEnabled = _state.value.nickname.isNotBlank())
                        } else {
                            sendEvent(SignUpEvent.ShowToast(R.string.signup_pwd_not_valid))
                        }
                    }
                    SignUpStep.NICKNAME -> {
                        if (nicknameValidCheck(_state.value.nickname)) {
                            sendEvent(SignUpEvent.Finish)
                        } else {
                            sendEvent(SignUpEvent.ShowToast(R.string.signup_nickname_not_valid))
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
}

@Immutable
sealed class SignUpEvent {
    data class ShowToast(val message: Int) : SignUpEvent()
    object Finish : SignUpEvent()
}