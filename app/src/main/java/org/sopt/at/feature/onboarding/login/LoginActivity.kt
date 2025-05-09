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
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.sopt.at.R
import org.sopt.at.feature.main.MainActivity
import org.sopt.at.feature.onboarding.signup.SignUpActivity
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme

@Stable
@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent{
            ATSOPTANDROIDTheme {
                val snackbarHostState = remember { SnackbarHostState() }
                val focusManager = LocalFocusManager.current
                val state by viewModel.state.collectAsState()
                LoginSideEffects(
                    viewModel = viewModel,
                    snackbarHostState = snackbarHostState,
                    onNavigateToMain = { userId ->
                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra(getString(R.string.key_id), userId)
                        setResult(RESULT_OK, intent)
                        startActivity(intent)
                        finish()
                    },
                    onNavigateToSignUp = {
                        val intent = Intent(this, SignUpActivity::class.java)
                        setResult(RESULT_OK, intent)
                        startActivity(intent)
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
                    title = getString(R.string.login_title),
                    snackbarHostState = snackbarHostState,
                    buttonValid = state.isButtonEnabled
                )
            }
        }
    }
}