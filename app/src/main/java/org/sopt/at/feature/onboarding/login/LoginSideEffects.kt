package org.sopt.at.feature.onboarding.login

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@Composable
fun LoginSideEffects(
    viewModel: LoginViewModel,
    snackbarHostState: SnackbarHostState,
    onNavigateToMain: (String) -> Unit,
    onNavigateToSignUp: () -> Unit
) {
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        viewModel.loginEvent.collect { event ->
            when (event) {
                is LoginEvent.NavigateToMain -> onNavigateToMain(event.id)
                LoginEvent.NavigateToSignUp -> onNavigateToSignUp()
                is LoginEvent.ShowSnackbar -> scope.launch {
                    snackbarHostState.showSnackbar(event.message)
                }
            }
        }
    }
}