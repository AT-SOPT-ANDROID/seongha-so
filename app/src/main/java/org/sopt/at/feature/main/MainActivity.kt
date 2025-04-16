package org.sopt.at.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PhoneIphone
import androidx.compose.material.icons.filled.SatelliteAlt
import androidx.compose.material.icons.filled.Search
import androidx.navigation.compose.rememberNavController
import org.sopt.at.core.navigation.NavRoute
import org.sopt.at.core.navigation.NavRouteData
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme



class MainActivity: ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //LoginActivity로부터 받은 정보 받기
        val id = intent.getStringExtra("id") ?: ""

        setContent{
            ATSOPTANDROIDTheme {
                val navController = rememberNavController()
                val tabs = MainNavRoutes.tabs
                MainScreen(
                    navController = navController,
                    tabs = tabs
                )
            }
        }
    }
}