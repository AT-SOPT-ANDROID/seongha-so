package org.sopt.at.feature.mypage

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardDoubleArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import org.sopt.at.R
import org.sopt.at.feature.main.Main
import org.sopt.at.feature.main.MainActivity
import org.sopt.at.feature.main.MainViewModel
import org.sopt.at.feature.onboarding.login.LoginAction
import org.sopt.at.feature.onboarding.login.LoginActivity
import org.sopt.at.feature.onboarding.login.LoginSideEffects
import org.sopt.at.feature.onboarding.signup.SignUpActivity
import org.sopt.at.ui.component.BasicOutlinedButton
import org.sopt.at.ui.component.ReturnButton
import org.sopt.at.ui.theme.Gray0
import org.sopt.at.ui.theme.Gray10
import org.sopt.at.ui.theme.Gray20
import org.sopt.at.ui.theme.Gray60

@Preview
@Composable
fun Preview(
) {
    MyScreen(
        navController = rememberNavController(),
        mainViewModel = hiltViewModel(),
    )
}

@Immutable
@Serializable
data object MyPage

@Composable
fun MyScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel,
    myViewModel: MyViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val state by myViewModel.state.collectAsState()
    MySideEffects(
        viewModel = myViewModel,
        snackbarHostState = snackbarHostState,
    )
    myViewModel.onAction(MyAction.LoadNickname(mainViewModel.userId))

    Scaffold(
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                ReturnButton(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 10.dp),
                    onClick = {navController.navigate(Main)})
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier.padding(bottom = 15.dp, top = 15.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            IconButton(
                                onClick = {},
                                modifier = Modifier
                                    .size(70.dp)
                                    .clip(RoundedCornerShape(5.dp))
                                    .background(Color.Black),
                                enabled = true
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.icon_tving),
                                    contentDescription = null,
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(state.nickname, fontSize = 17.sp, color = Gray0)
                            IconButton(
                                onClick = {},
                                modifier = Modifier.size(30.dp),
                                enabled = true
                            ) {
                                Icon(
                                    modifier = Modifier,
                                    imageVector = Icons.Filled.Edit,
                                    tint = Gray20,
                                    contentDescription = null
                                )
                            }
                        }
                        BasicOutlinedButton(Modifier
                            .width(100.dp)
                            .height(35.dp), context.getString(R.string.profile_conversion_button), {}, true)
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Gray60, RoundedCornerShape(5.dp))
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(context.getString(R.string.profile_my_ticket_description), fontSize = 13.sp, color = Gray10)
                            Text(context.getString(R.string.profile_have_no_ticket), fontSize = 15.sp, color = Gray10)
                        }
                        Spacer(Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(context.getString(R.string.profile_my_cash_description), fontSize = 13.sp, color = Gray10)
                            Text(context.getString(R.string.profile_have_no_cash), fontSize = 15.sp, color = Gray10)
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Gray60, RoundedCornerShape(5.dp))
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(context.getString(R.string.profile_default_description), fontSize = 13.sp, color = Gray10)
                            IconButton(
                                onClick = {},
                                modifier = Modifier,
                                enabled = true
                            ) {
                                Icon(
                                    modifier = Modifier,
                                    imageVector = Icons.Filled.KeyboardDoubleArrowRight,
                                    tint = Gray20,
                                    contentDescription = null
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    BasicOutlinedButton(
                        modifier = Modifier.fillMaxWidth().height(50.dp),
                        text = context.getString(R.string.logout_button),
                        onClick = {
                            // LoginActivity로 이동
                            val intent = Intent(context, LoginActivity::class.java)
                            context.startActivity(intent)
                            if (context is Activity) {
                                context.finish()
                            }
                        },
                        buttonValid = true
                    )

                }
            }
        }
    }
}