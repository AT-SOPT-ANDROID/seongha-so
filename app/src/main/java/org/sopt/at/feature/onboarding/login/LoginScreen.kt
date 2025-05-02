package org.sopt.at.feature.onboarding.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.ui.component.BasicButton
import org.sopt.at.ui.component.LoginTextField
import org.sopt.at.ui.component.ReturnButton
import org.sopt.at.ui.theme.Gray0
import org.sopt.at.ui.theme.Gray20

@Preview
@Composable
private fun Preview(
){
    val snackbarHostState = remember { SnackbarHostState() }
    LoginSCreen(
        idValue = "",
        pwdValue = "",
        onIdValueChange = {value -> },
        onPwdValueChange = {value -> },
        onReturnClicked = {},
        onLoginClicked = {},
        onFindIdClicked = {},
        onFindPwdClicked = {},
        onSignupClicked = {},
        title = "TVING ID 로그인",
        snackbarHostState = snackbarHostState,
        buttonValid = false
    )
}

@Composable
fun LoginSCreen(
    idValue: String,
    pwdValue: String,
    onIdValueChange: (String) -> Unit,
    onPwdValueChange: (String) -> Unit,
    onReturnClicked: () -> Unit,
    onLoginClicked: () -> Unit,
    onFindIdClicked: () -> Unit,
    onFindPwdClicked: () -> Unit,
    onSignupClicked: () -> Unit,
    title: String,
    snackbarHostState: SnackbarHostState,
    buttonValid: Boolean
) {
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        )
        {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ){
                ReturnButton(modifier = Modifier.fillMaxWidth().padding(top = 10.dp, start = 10.dp), onClick = onReturnClicked)
                Column(
                    modifier = Modifier.padding(20.dp).fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceBetween
                    ){
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = title,
                            modifier = Modifier,
                            fontSize = 25.sp,
                            color = Gray0)
                        Spacer(modifier = Modifier.height(30.dp))
                    }

                    Column (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = BiasAlignment.Horizontal(-1f),
                        verticalArrangement = Arrangement.SpaceBetween
                    ){
                        LoginTextField(modifier = Modifier.fillMaxWidth().padding(top = 5.dp, bottom = 5.dp), value = idValue, onValueChange = onIdValueChange, placeholder = "아이디", isPassword = false)
                        LoginTextField(modifier = Modifier.fillMaxWidth().padding(top = 5.dp, bottom = 5.dp), value = pwdValue, onValueChange = onPwdValueChange, placeholder = "비밀번호", isPassword = true)
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    BasicButton(modifier = Modifier.fillMaxWidth().height(50.dp), text = "로그인하기", onClick = onLoginClicked, buttonValid = buttonValid)
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    )
                    {
                        TextButton(
                            onClick = onFindIdClicked
                        ) {
                            Text("아이디 찾기", fontSize = 15.sp, textAlign = TextAlign.Center, color = Gray20)
                        }
                        Spacer(modifier = Modifier.padding(7.dp).width(1.dp).height(20.dp).background(Gray20))
                        TextButton(
                            onClick = onFindPwdClicked
                        ) {
                            Text("비밀번호 찾기", fontSize = 15.sp, textAlign = TextAlign.Center, color = Gray20)
                        }
                        Spacer(modifier = Modifier.padding(7.dp).width(1.dp).height(20.dp).background(Gray20))
                        TextButton(
                            onClick = onSignupClicked
                        ) {
                            Text("회원가입", fontSize = 15.sp, textAlign = TextAlign.Center, color = Gray20)
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = buildAnnotatedString {
                        append("이 사이트는 Google reCAPTCHA로 보호되며,\nGoogle 개인정보 처리방침과 서비스 약관이 적용됩니다.")
                        addStyle(style = SpanStyle(textDecoration = TextDecoration.Underline,color = Gray20),start = 31,end = 47)
                        addStyle(style = SpanStyle(textDecoration = TextDecoration.Underline,color = Gray20),start = 49,end = 55)
                        },
                        fontSize = 12.sp, textAlign = TextAlign.Center, color = Gray20
                    )
                }
            }
        }
    }
}