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
                    onFinish = { id, pwd ->
                        val intent = Intent(this, LoginActivity::class.java)
                        intent.putExtra("id", id)
                        intent.putExtra("pwd", pwd)
                        setResult(RESULT_OK, intent)
                        finish()
                    }
                )

                when (state.step) {
                    SignUpStep.ID -> {
                        SignUpScreen(
                            value = state.id,
                            placeholder = "아이디",
                            title = "아이디를 입력해주세요.",
                            description = "영문 소문자 또는 영문 대문자, 숫자 조합 6~12 자리",
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
                            placeholder = "비밀번호",
                            title = "비밀번호를 입력해주세요.",
                            description = "영문, 숫자, 특수문자(~!@$%^&*) 조합 8~15자리",
                            isPassword = true,
                            onValueChange = {viewModel.onAction(SignUpAction.UpdatePwd(it))},
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