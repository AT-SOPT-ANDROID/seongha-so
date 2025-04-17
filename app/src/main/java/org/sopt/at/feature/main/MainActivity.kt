package org.sopt.at.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme



class MainActivity: ComponentActivity(){
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //LoginActivity로부터 받은 정보 저장
        viewModel.getId = intent.getStringExtra("id") ?: ""

        setContent{
            ATSOPTANDROIDTheme {
                val entireNavController = rememberNavController()
                EntireNavHost(
                    navController = entireNavController,
                    viewModel = viewModel)
            }
        }
    }
}