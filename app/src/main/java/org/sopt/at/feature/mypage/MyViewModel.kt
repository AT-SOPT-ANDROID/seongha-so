package org.sopt.at.feature.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.sopt.at.core.utils.Result
import org.sopt.at.domain.usecase.GetMyNicknameUseCase
import org.sopt.at.domain.usecase.LoginUseCase
import org.sopt.at.feature.onboarding.login.LoginAction
import org.sopt.at.feature.onboarding.login.LoginEvent
import org.sopt.at.feature.onboarding.login.LoginState

@HiltViewModel
class MyViewModel @Inject constructor(
    private val getMyNicknameUseCase: GetMyNicknameUseCase
): ViewModel()
{
    private val _state = MutableStateFlow(MyState())
    val state: StateFlow<MyState> = _state
    private val _event = Channel<MyEvent>()
    val event = _event.receiveAsFlow()

    fun onAction(action: MyAction) {
        when (action) {
            is MyAction.LoadNickname -> {
                getMyNickname(action.userId)
            }
        }
    }

    private fun getMyNickname(userId: Long) {
        viewModelScope.launch {
            when (val result = getMyNicknameUseCase(userId)) {
                is Result.Success -> {
                    _state.value = _state.value.copy(
                        nickname = result.data.nickname
                    )
                }
                is Result.Failure -> {
                    _event.send(MyEvent.ShowSnackbarByString(result.message))
                }
                is Result.Error -> {
                    _event.send(MyEvent.ShowSnackbarByInt(result.message))
                }
            }
        }
    }
}

sealed class MyEvent {
    data class ShowSnackbarByInt(val message: Int) : MyEvent()
    data class ShowSnackbarByString(val message: String) : MyEvent()
}
