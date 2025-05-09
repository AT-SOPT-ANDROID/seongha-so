package org.sopt.at.feature.onboarding.signup

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext


@Composable
fun SignUpSideEffects(
    viewModel: SignUpViewModel,
    onFinish: () -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                is SignUpEvent.ShowToast -> Toast.makeText(context, context.getString(event.message), Toast.LENGTH_SHORT).show()
                is SignUpEvent.Finish -> onFinish()
            }
        }
    }
}