package org.sopt.at.feature.mypage

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.annotation.RestrictTo
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.sopt.at.ui.component.BasicButton
import org.sopt.at.ui.component.LoginTextField
import org.sopt.at.ui.component.ReturnBar
import org.sopt.at.ui.theme.Gray0
import org.sopt.at.ui.theme.Gray20
import org.sopt.at.ui.theme.Gray40
import org.sopt.at.ui.theme.Gray60

@Preview
@Composable
fun Preview(
){
    val snackbarHostState = remember { SnackbarHostState() }
    MyScreen(
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
fun MyScreen(
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
                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ){
                ReturnBar(Modifier.fillMaxWidth().padding(top = 10.dp, start = 10.dp), onReturnClicked)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){

                    }

                }
            }
        }
    }
}