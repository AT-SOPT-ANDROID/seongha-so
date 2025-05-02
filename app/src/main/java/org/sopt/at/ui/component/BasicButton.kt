package org.sopt.at.ui.component

import NoRippleInteractionSource
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.sopt.at.ui.theme.Gray0
import org.sopt.at.ui.theme.Gray20
import org.sopt.at.ui.theme.Gray40
import org.sopt.at.ui.theme.Red40

@Composable
fun BasicButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    buttonValid: Boolean
) {
    Button(
        onClick = onClick,
        interactionSource = NoRippleInteractionSource(),
        modifier = modifier,
        colors = if(buttonValid) ButtonDefaults.buttonColors(containerColor = Red40) else ButtonDefaults.buttonColors(containerColor = Gray40),
        enabled = buttonValid,
        shape = RoundedCornerShape(5.dp)
    ) {
        Text(text, fontSize = 17.sp, color = if(buttonValid) Color.White else Gray20)
    }
}