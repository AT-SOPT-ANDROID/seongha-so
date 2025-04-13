package org.sopt.at.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.ui.theme.Gray0
import org.sopt.at.ui.theme.Gray20
import org.sopt.at.ui.theme.Gray40

@Composable
fun BasicOutlinedButton(
    modifier: Modifier = Modifier,
    text: String,
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
        Text(text, fontSize = 17.sp, color = if(buttonValid) Gray20 else Gray40)
    }
}