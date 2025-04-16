package org.sopt.at.feature.onboarding

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalFocusManager
import kotlinx.coroutines.launch
import org.sopt.at.feature.main.MainActivity
import org.sopt.at.feature.mypage.MyActivity
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme

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
                val scope = rememberCoroutineScope()
                val buttonValid = viewModel.textId.isNotBlank() && viewModel.textPwd.isNotBlank()
                val focusManager = LocalFocusManager.current
                LoginSCreen(
                    idValue = viewModel.textId,
                    pwdValue = viewModel.textPwd,
                    onIdValueChange = {value -> viewModel.textId = value},
                    onPwdValueChange = {value -> viewModel.textPwd = value},
                    onReturnClicked = {
                        //TODO 비워둠
                    },
                    onLoginClicked = {
                        focusManager.clearFocus()
                        if(viewModel.loginValidCheck()){
                            //MyActivity로 이동하기
                            val intent = Intent(this, MainActivity::class.java)
                            intent.putExtra("id", viewModel.textId)
                            setResult(RESULT_OK, intent)
                            startActivity(intent)
                            finish()
                        }
                        else{
                            //스낵바 띄우기
                            scope.launch {
                                snackbarHostState.showSnackbar("아이디 또는 비밀번호가 유효하지 않습니다.")
                            }
                        }
                    },
                    onFindIdClicked = {
                        //TODO 비워둠
                    },
                    onFindPwdClicked = {
                        //TODO 비워둠
                    },
                    onSignupClicked = {
                        //SignUpActivity로 이동하기
                        val intent = Intent(this, SignUpActivity::class.java)
                        getResult.launch(intent)
                    },
                    title = "TVING ID 로그인",
                    snackbarHostState = snackbarHostState,
                    buttonValid = buttonValid
                )
            }
        }
    }
}