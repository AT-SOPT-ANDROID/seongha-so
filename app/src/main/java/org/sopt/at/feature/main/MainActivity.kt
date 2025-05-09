package org.sopt.at.feature.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Stable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.at.R
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme

@Stable
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // LoginActivity로부터 받은 정보 저장
        val userId = intent.getLongExtra(this.getString(R.string.key_id), 0L)

        setContent {
            ATSOPTANDROIDTheme {
                val mainViewModel: MainViewModel = hiltViewModel()
                mainViewModel.storeId(userId)
                val entireNavController = rememberNavController()

                EntireNavHost(
                    navController = entireNavController,
                    mainViewModel = mainViewModel,
                )
            }
        }
    }
}
