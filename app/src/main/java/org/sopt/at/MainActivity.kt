package org.sopt.at

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.style.UnderlineSpan
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ATSOPTANDROIDTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Sopt()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Sopt() {
    val context : Context = LocalContext.current
    var textId by remember { mutableStateOf("") }
    var textPwd by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    var snackbarHost = SnackbarHost(hostState = snackbarHostState)
    Column(
        modifier = Modifier.padding(20.dp).fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Welcome To Sopt",
            modifier = Modifier,
            fontSize = 30.sp,
            color = Color.Black)
        Column (
            modifier = Modifier,
            horizontalAlignment = BiasAlignment.Horizontal(-1f),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Text("ID", textAlign = TextAlign.Start)
            TextField(
                value = textId,
                onValueChange = {value ->
                    textId = value},
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = { Text("사용자 이름 입력") },
                singleLine = true
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text("비밀번호", textAlign = TextAlign.Start)
            TextField(
                value = textPwd,
                onValueChange = {value -> textPwd = value},
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = { Text("비밀번호 입력") },
                singleLine = true
            )
        }
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text("회원가입하기", textAlign = TextAlign.Start, fontSize = 15.sp, modifier = Modifier.clickable {
                val intent = Intent(context, SignupActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                }
                context.startActivity(intent)
            })
            Button(
                onClick = {
                    if(textId.length >= 6){
                        Toast.makeText(context, "로그인 완료", Toast.LENGTH_SHORT).show()
                        scope.launch {
                            snackbarHostState.showSnackbar("로그인 완료")
                        }
                    }
                    },
                modifier = Modifier.padding(10.dp).fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(69, 92, 145, 255)),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text("로그인 하기", color = Color.White)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ATSOPTANDROIDTheme {
        //Greeting("Android")
        Sopt()
    }
}