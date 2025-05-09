package org.sopt.at.feature.main

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

@Stable
class MainViewModel: ViewModel() {
    var userId by mutableStateOf(0L)

    fun storeId(userId: Long): Unit{
        this.userId = userId;
    }
}