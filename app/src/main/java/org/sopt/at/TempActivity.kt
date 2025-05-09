package org.sopt.at

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//class TempActivity: ComponentActivity() {
//    private val userService by lazy { ServicePool.userService }
//    private val userState = mutableStateOf<ResponseSingleUserDto?>(null)
//    private val usersState = mutableStateOf<ResponseUserListDto?>(null)
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        getSingleUser(userId = 2)
//        getUserList(page = 1)
//
//        enableEdgeToEdge()
//        setContent {
//            ATSOPTANDROIDTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        users = usersState.value?.data?: emptyList(),
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//
//    private fun getSingleUser(userId: Int) {
//        userService.getSingleUser(userId = userId).enqueue(object :
//            Callback<ResponseSingleUserDto> {
//            override fun onResponse(
//                call: Call<ResponseSingleUserDto>,
//                response: Response<ResponseSingleUserDto>,
//            ) {
//                if (response.isSuccessful) {
//                    userState.value = response.body()
//                } else {
//                    val error = response.message()
//                    Log.e("error", error.toString())
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseSingleUserDto>, t: Throwable) {
//                Log.e("failure", t.message.toString())
//            }
//        })
//    }
//
//    private fun getUserList(page: Int) {
//        userService.getUserList(page = page).enqueue(object :
//            Callback<ResponseUserListDto> {
//            override fun onResponse(
//                call: Call<ResponseUserListDto>,
//                response: Response<ResponseUserListDto>,
//            ) {
//                if (response.isSuccessful) {
//                    usersState.value = response.body()
//                } else {
//                    val error = response.message()
//                    Log.e("error", error.toString())
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseUserListDto>, t: Throwable) {
//                Log.e("failure", t.message.toString())
//            }
//        })
//    }
//}
//
//@Composable
//fun Greeting(users: List<ResponseUserDataDto>, modifier: Modifier = Modifier) {
//
//    Column {
//        for (user in users){
//            val name = user.firstName + user.lastName
//            Text(
//                text = "Name is $name!",
//                modifier = modifier
//            )
//        }
//    }
//
//}