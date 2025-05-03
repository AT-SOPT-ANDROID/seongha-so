package org.sopt.at

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import org.sopt.at.data.remote.dto.ResponseSingleUserDto

class TempViewModel: ViewModel() {
    private val _userState = mutableStateOf<ResponseSingleUserDto?>(null)
    val userState: State<ResponseSingleUserDto?> get() = _userState
}