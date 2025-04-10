package org.sopt.at.feature.onboarding

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme

class LoginActivity : ComponentActivity() {
    private lateinit var getResult : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //SignUpActivity와 정보 주고받기
        getResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                val getId = result.data?.getStringExtra("id") ?: ""
                val getPwd = result.data?.getStringExtra("pwd") ?: ""
                Toast.makeText(this, "id: $getId pwd: $getPwd", Toast.LENGTH_SHORT).show();
            }
        }

        setContent{
            ATSOPTANDROIDTheme {
                LoginSCreen(
                    onLoginClicked = {
                        //SignUpActivity로 이동하기
                        val intent = Intent(this, SignUpActivity::class.java)
                        getResult.launch(intent)
                    },
                    onReturnClicked = {

                    }
                )
            }
        }
    }
}