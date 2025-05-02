package org.sopt.at.feature.onboarding.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalFocusManager
import kotlinx.coroutines.launch
import org.sopt.at.feature.main.MainActivity
import org.sopt.at.feature.onboarding.signup.SignUpActivity
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme

@Stable
class LoginActivity : ComponentActivity() {
    private lateinit var getResult : ActivityResultLauncher<Intent>
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //SignUpActivity와 정보 주고받기
        getResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                viewModel.getId = result.data?.getStringExtra("id") ?: ""
                viewModel.getPwd = result.data?.getStringExtra("pwd") ?: ""
            }
        }

        setContent{
            ATSOPTANDROIDTheme {
                val snackbarHostState = remember { SnackbarHostState() }
                val focusManager = LocalFocusManager.current
                val state by viewModel.state.collectAsState()
                LoginSideEffects(
                    viewModel = viewModel,
                    snackbarHostState = snackbarHostState,
                    onNavigateToMain = { id ->
                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("id", id)
                        setResult(RESULT_OK, intent)
                        startActivity(intent)
                        finish()
                    },
                    onNavigateToSignUp = {
                        val intent = Intent(this, SignUpActivity::class.java)
                        getResult.launch(intent)
                    }
                )

                LoginSCreen(
                    idValue = state.id,
                    pwdValue = state.pwd,
                    onIdValueChange = {viewModel.onAction(LoginAction.UpdateId(it))},
                    onPwdValueChange = {viewModel.onAction(LoginAction.UpdatePwd(it))},
                    onReturnClicked = {
                        //TODO 비워둠
                    },
                    onLoginClicked = {
                        focusManager.clearFocus()
                        viewModel.onAction(LoginAction.LoginClicked)
                    },
                    onFindIdClicked = {
                        //TODO 비워둠
                    },
                    onFindPwdClicked = {
                        //TODO 비워둠
                    },
                    onSignupClicked = {
                        viewModel.onAction(LoginAction.SignupClicked)
                    },
                    title = "TVING ID 로그인",
                    snackbarHostState = snackbarHostState,
                    buttonValid = state.isButtonEnabled
                )
            }
        }
    }
}