package org.sopt.at.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme

class MainActivity: ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            ATSOPTANDROIDTheme {
                Scaffold (
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    val navController = rememberNavController()
                }
            }
        }
    }
}