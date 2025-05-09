package org.sopt.at.feature.mypage

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch
import org.sopt.at.feature.onboarding.login.LoginEvent

@Composable
fun MySideEffects (
    viewModel: MyViewModel,
    snackbarHostState: SnackbarHostState,
    )
{
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                is MyEvent.ShowSnackbarByInt -> scope.launch {
                    snackbarHostState.showSnackbar(context.getString(event.message))
                }
                is MyEvent.ShowSnackbarByString -> scope.launch {
                    snackbarHostState.showSnackbar(event.message)
                }
            }
        }
    }
}
