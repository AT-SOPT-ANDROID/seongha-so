package org.sopt.at.feature.onboarding

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.sopt.at.ui.component.ReturnBar
import org.sopt.at.ui.theme.Gray0
import org.sopt.at.ui.theme.Gray20
import org.sopt.at.ui.theme.Gray40
import org.sopt.at.ui.theme.Gray60

@Preview
@Composable
fun LoginSCreen() {
    val context : Context = LocalContext.current
    var textId by remember { mutableStateOf("") }
    var textPwd by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    var snackbarHost = SnackbarHost(hostState = snackbarHostState)

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ){
        ReturnBar()
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
                Spacer(modifier = Modifier.fillMaxWidth().height(20.dp))
                Text(text = "TVING ID 로그인",
                    modifier = Modifier,
                    fontSize = 25.sp,
                    color = Gray0)
                Spacer(modifier = Modifier.fillMaxWidth().height(30.dp))
            }

            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = BiasAlignment.Horizontal(-1f),
                verticalArrangement = Arrangement.SpaceBetween
            ){
                TextField(
                    value = textId,
                    onValueChange = {value ->
                        textId = value},
                    modifier = Modifier.fillMaxWidth().padding(top = 5.dp, bottom = 5.dp),
                    placeholder = { Text(text ="아이디", color = Gray20) },
                    singleLine = true,
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Gray60,
                        unfocusedContainerColor = Gray60,
                        disabledContainerColor = Gray60,
                        errorContainerColor = Gray60,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent
                    )
                )
                Box(
                    modifier = Modifier.fillMaxWidth().padding(top = 5.dp, bottom = 5.dp)
                )
                {
                    TextField(
                        value = textPwd,
                        onValueChange = {value -> textPwd = value},
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text(text ="비밀번호", color = Gray20) },
                        singleLine = true,
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Gray60,
                            unfocusedContainerColor = Gray60,
                            disabledContainerColor = Gray60,
                            errorContainerColor = Gray60,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = Color.Transparent
                        )
                    )
                    IconButton(
                        onClick = {},
                        modifier = Modifier.align(Alignment.CenterEnd),
                        enabled = true
                    ) {
                        Icon(
                            modifier = Modifier,
                            imageVector = Icons.Filled.VisibilityOff,
                            tint = Gray20,
                            contentDescription = null
                        )
                    }
                }

            }
            Button(
                onClick = {
                    if(textId.length >= 6){
                        Toast.makeText(context, "로그인 완료", Toast.LENGTH_SHORT).show()
                        scope.launch {
                            snackbarHostState.showSnackbar("로그인 완료")
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp, bottom = 20.dp).height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Gray40),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text("로그인하기", fontSize = 17.sp, color = Gray20)
            }
            Row(
                modifier = Modifier.height(30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            )
            {
                Text("아이디 찾기", fontSize = 15.sp, textAlign = TextAlign.Center, color = Gray20)
                Spacer(modifier = Modifier.padding(7.dp)
                    .width(1.dp)
                    .fillMaxHeight()
                    .background(Gray20))
                Text("비밀번호 찾기", fontSize = 15.sp, textAlign = TextAlign.Center, color = Gray20)
                Spacer(modifier = Modifier.padding(7.dp)
                    .width(1.dp)
                    .fillMaxHeight()
                    .background(Gray20))
                Text("회원가입", fontSize = 15.sp, textAlign = TextAlign.Center, color = Gray20)
            }
            Spacer(modifier = Modifier
                .height(15.dp)
                .fillMaxWidth())
            Text("이 사이트는 Google reCAPTCHA로 보호되며, \nGoogle 개인정보 처리방침과 서비스 약관이 적용됩니다.", fontSize = 12.sp, textAlign = TextAlign.Center, color = Gray20)
        }
    }
}