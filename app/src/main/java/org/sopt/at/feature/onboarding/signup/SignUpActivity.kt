package org.sopt.at.feature.onboarding.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.sopt.at.R
import org.sopt.at.feature.onboarding.login.LoginActivity
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme

@Stable
class SignUpActivity : ComponentActivity() {
    private val viewModel: SignUpViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ATSOPTANDROIDTheme {
                val state by viewModel.state.collectAsState()

                SignUpSideEffects(
                    viewModel = viewModel,
                    onFinish = {
                        val intent = Intent(this, LoginActivity::class.java)
                        setResult(RESULT_OK, intent)
                        finish()
                    }
                )

                when (state.step) {
                    SignUpStep.ID -> {
                        SignUpScreen(
                            value = state.id,
                            placeholder = getString(R.string.signup_placeholder_id),
                            title = getString(R.string.signup_title_id),
                            description = getString(R.string.signup_description_id),
                            isPassword = false,
                            onValueChange = {viewModel.onAction(SignUpAction.UpdateId(it))},
                            onNextButtonClicked = {viewModel.onAction(SignUpAction.NextClicked)},
                            onReturnClicked = {viewModel.onAction(SignUpAction.ReturnClicked)},
                            buttonValid = state.isButtonEnabled
                        )
                    }
                    SignUpStep.PASSWORD -> {
                        SignUpScreen(
                            value = state.pwd,
                            placeholder = getString(R.string.signup_placeholder_pwd),
                            title = getString(R.string.signup_title_pwd),
                            description = getString(R.string.signup_description_pwd),
                            isPassword = true,
                            onValueChange = {viewModel.onAction(SignUpAction.UpdatePwd(it))},
                            onNextButtonClicked = {viewModel.onAction(SignUpAction.NextClicked)},
                            onReturnClicked = {viewModel.onAction(SignUpAction.ReturnClicked)},
                            buttonValid = state.isButtonEnabled
                        )
                    }
                    SignUpStep.NICKNAME -> {
                        SignUpScreen(
                            value = state.nickname,
                            placeholder = getString(R.string.signup_placeholder_nickname),
                            title = getString(R.string.signup_title_nickname),
                            description = getString(R.string.signup_description_nickname),
                            isPassword = false,
                            onValueChange = {viewModel.onAction(SignUpAction.UpdateNickname(it))},
                            onNextButtonClicked = {viewModel.onAction(SignUpAction.NextClicked)},
                            onReturnClicked = {viewModel.onAction(SignUpAction.ReturnClicked)},
                            buttonValid = state.isButtonEnabled
                        )
                    }
                }
            }
        }
    }
}