package org.sopt.at.feature.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var id by mutableStateOf("")

    fun storeId(id: String): Unit{
        this.id = id;
    }
}