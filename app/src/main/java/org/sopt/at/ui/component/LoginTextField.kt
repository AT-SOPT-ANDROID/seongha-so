package org.sopt.at.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import org.sopt.at.ui.theme.Gray0
import org.sopt.at.ui.theme.Gray20
import org.sopt.at.ui.theme.Gray60

@Composable
fun LoginTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false
){
    var pwdVisible by remember { mutableStateOf(false) }

    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth().padding(top = 5.dp, bottom = 5.dp),
        placeholder = { Text(text = placeholder, color = Gray20) },
        singleLine = true,
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Gray60,
            unfocusedContainerColor = Gray60,
            disabledContainerColor = Gray60,
            errorContainerColor = Gray60,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            focusedTextColor = Gray0,
            unfocusedTextColor = Gray0,
            disabledTextColor = Gray0,
            errorTextColor = Gray0
        ),
        visualTransformation = if(isPassword){if (pwdVisible) VisualTransformation.None else PasswordVisualTransformation()} else VisualTransformation.None,
        keyboardOptions = if(isPassword) KeyboardOptions(keyboardType = KeyboardType.Password) else KeyboardOptions.Default,
        trailingIcon = {
            if (isPassword) {
                val image = if (pwdVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff
                val description = if (pwdVisible) "Hide password" else "Show password"
                IconButton(onClick = { pwdVisible = !pwdVisible }) {
                    Icon(imageVector = image, description)
                }
            }
        }
    )
}