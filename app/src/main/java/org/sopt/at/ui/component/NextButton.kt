package org.sopt.at.ui.component

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.sopt.at.ui.theme.Gray0
import org.sopt.at.ui.theme.Gray20

@Composable
fun NextButton(
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().height(50.dp)
            .border(0.5.dp, Gray0, RoundedCornerShape(5.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
        border = BorderStroke(2.dp, Gray0),
        shape = RoundedCornerShape(5.dp)
    ) {
        Text("다음", fontSize = 17.sp, color = Gray20)
    }
}