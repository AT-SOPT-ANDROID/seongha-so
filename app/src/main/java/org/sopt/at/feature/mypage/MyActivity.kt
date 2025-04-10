package org.sopt.at.feature.mypage

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import org.sopt.at.feature.onboarding.LoginActivity
import org.sopt.at.feature.onboarding.LoginSCreen
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme

class MyActivity: ComponentActivity() {
    private val viewModel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //LoginActivity로부터 받은 정보 받기
        viewModel.getId = intent.getStringExtra("id") ?: ""

        setContent {
            ATSOPTANDROIDTheme {
                MyScreen(
                    textId = viewModel.getId,
                    context = this,
                    onLoginClicked = {
                        //LoginActivity로 이동하기
                        val intent = Intent(this, LoginActivity::class.java)
                        setResult(RESULT_OK, intent)
                        startActivity(intent)
                        finish()
                    }
                )
            }
        }
    }
}