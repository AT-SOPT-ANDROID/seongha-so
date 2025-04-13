package org.sopt.at.feature.mypage

import android.content.Context
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.R
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
        textId = "sosongha3",
        context = LocalContext.current,
        onLoginClicked = {}
    )
}

@Composable
fun MyScreen(
    textId: String,
    context: Context,
    onLoginClicked: () -> Unit,
) {
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
                        .padding(top = 10.dp, start = 10.dp), {})
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
                            Text(textId, fontSize = 17.sp, color = Gray0)
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
                            .height(35.dp), "프로필 전환", {}, true)
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
                            Text("나의 이용권", fontSize = 13.sp, color = Gray10)
                            Text("사용중인 이용권이 없습니다", fontSize = 15.sp, color = Gray10)
                        }
                        Spacer(Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("티빙 캐시", fontSize = 13.sp, color = Gray10)
                            Text("0", fontSize = 15.sp, color = Gray10)
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
                            Text("이용권을 구매하고 tvN, Jtbc 등 인기 시리즈와\n다양한 영화 콘텐츠를 자유롭게 시청하세요!", fontSize = 13.sp, color = Gray10)
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
                    BasicOutlinedButton(Modifier
                        .fillMaxWidth()
                        .height(50.dp), "로그아웃", onLoginClicked, true)

                }
            }
        }
    }
}