package org.sopt.at.ui.component

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

@Composable
fun NextButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonValid: Boolean
) {
    val interactionSource = remember { MutableInteractionSource() }
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        border = BorderStroke(0.5.dp, if(buttonValid) Gray20 else Gray40),
        enabled = buttonValid,
        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Black, contentColor = Gray0),
        shape = RoundedCornerShape(5.dp),
        interactionSource = interactionSource
    ) {
        Text("다음", fontSize = 17.sp, color = if(buttonValid) Gray20 else Gray40)
    }
}