package org.sopt.at.feature.onboarding.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import org.sopt.at.feature.onboarding.login.LoginActivity
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme

class SignUpActivity : ComponentActivity() {
    private val viewModel: SignUpViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ATSOPTANDROIDTheme {
                val buttonValid: Boolean
                when (viewModel.currentStep) {
                    SignUpStep.ID -> {
                        buttonValid = viewModel.textId.isNotBlank()
                        SignUpScreen(
                            value = viewModel.textId,
                            placeholder = "아이디",
                            title = "아이디를 입력해주세요.",
                            description = "영문 소문자 또는 영문 대문자, 숫자 조합 6~12 자리",
                            isPassword = false,
                            onValueChange = {value -> viewModel.textId = value},
                            onNextButtonClicked = {
                                if(viewModel.idValidCheck(viewModel.textId))
                                    viewModel.nextStep()
                                else{
                                    Toast.makeText(this, "아이디가 유효하지 않습니다.", Toast.LENGTH_SHORT).show()
                                }
                            },
                            onReturnClicked = {
                                val intent = Intent(this, LoginActivity::class.java)
                                setResult(RESULT_OK, intent)
                                finish()
                            },
                            buttonValid = buttonValid
                        )
                    }
                    SignUpStep.PASSWORD -> {
                        buttonValid = viewModel.textPwd.isNotBlank()
                        SignUpScreen(
                            value = viewModel.textPwd,
                            placeholder = "비밀번호",
                            title = "비밀번호를 입력해주세요.",
                            description = "영문, 숫자, 특수문자(~!@$%^&*) 조합 8~15자리",
                            isPassword = true,
                            onValueChange = {value -> viewModel.textPwd = value},
                            onNextButtonClicked = {
                                if(viewModel.pwdValidCheck(viewModel.textPwd)) {
                                    //결과와 함께 이전 액티비티로 돌아가기
                                    val intent = Intent(this, LoginActivity::class.java)
                                    intent.putExtra("id", viewModel.textId)
                                    intent.putExtra("pwd", viewModel.textPwd)
                                    setResult(RESULT_OK, intent)
                                    finish()
                                }
                                else{
                                    Toast.makeText(this, "비밀번호가 유효하지 않습니다.", Toast.LENGTH_SHORT).show()
                                }
                            },
                            onReturnClicked = {
                                viewModel.previewStep()
                            },
                            buttonValid = buttonValid
                        )
                    }
                }
            }
        }
    }
}