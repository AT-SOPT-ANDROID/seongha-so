package org.sopt.at.feature.onboarding

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
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
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.sopt.at.ui.component.NextButton
import org.sopt.at.ui.component.ReturnBar
import org.sopt.at.ui.component.SignupTextField
import org.sopt.at.ui.theme.Gray0
import org.sopt.at.ui.theme.Gray20
import org.sopt.at.ui.theme.Gray40
import org.sopt.at.ui.theme.Gray60

@Preview
@Composable
fun SignUpScreen(
    value: String,
    onValueChange: (String) -> Unit,
    onNextButtonClicked: () -> Unit,
    placeholder: String,
    title: String,
    description: String,
    isPassword: Boolean
) {
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            ReturnBar()
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))
                    Text(
                        text = title,
                        modifier = Modifier,
                        fontSize = 25.sp,
                        color = Gray0
                    )
                    Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))
                }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = BiasAlignment.Horizontal(-1f),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    SignupTextField(value, onValueChange, placeholder, isPassword)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(description, fontSize = 12.sp, textAlign = TextAlign.Start, color = Gray20)
                }
            }
        }
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            NextButton(onNextButtonClicked)
        }
    }
}