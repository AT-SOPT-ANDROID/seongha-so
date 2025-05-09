package org.sopt.at.feature.onboarding.login

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch

@Composable
fun LoginSideEffects(
    viewModel: LoginViewModel,
    snackbarHostState: SnackbarHostState,
    onNavigateToMain: (Long) -> Unit,
    onNavigateToSignUp: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel.loginEvent.collect { event ->
            when (event) {
                is LoginEvent.NavigateToMain -> onNavigateToMain(event.userId)
                LoginEvent.NavigateToSignUp -> onNavigateToSignUp()
                is LoginEvent.ShowSnackbar -> scope.launch {
                    snackbarHostState.showSnackbar(context.getString(event.message))
                }
            }
        }
    }
}