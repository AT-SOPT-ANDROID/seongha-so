package org.sopt.at

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme

class TempActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent{
            ATSOPTANDROIDTheme {
                TempSCreen()
            }
        }
    }
}

@Preview(backgroundColor = 0xFFFFFFFF)
@Composable
fun TempSCreen(){
    var count by remember { mutableStateOf(0) }
    val context = LocalContext.current
    LaunchedEffect(count) {
        if(count >= 5){
            Toast.makeText(context, "5 이상", Toast.LENGTH_SHORT).show()
        }
    }
    val countBiggerThanFive by remember {
        derivedStateOf { count < 10 }
    }
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Button(
            modifier = Modifier,
            onClick = {
                count++
            },
            enabled = countBiggerThanFive,
        ) { }
        Text(
            modifier = Modifier,
            text = count.toString(),
        )
    }

}