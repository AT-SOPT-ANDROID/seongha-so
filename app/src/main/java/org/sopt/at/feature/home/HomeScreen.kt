package org.sopt.at.feature.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ConnectedTv
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.sopt.at.R
import org.sopt.at.core.tab.HomeTabType
import org.sopt.at.core.tab.TabType
import org.sopt.at.domain.entity.Content
import org.sopt.at.feature.mypage.MyPage
import org.sopt.at.ui.component.AtSoptContentRow
import org.sopt.at.ui.component.AtSoptContentViewPager
import org.sopt.at.ui.component.AtSoptTabBar
import org.sopt.at.ui.theme.Gray20
import org.sopt.at.ui.theme.Red40

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun Preview(){
    HomeScreen(entireNavController = rememberNavController())
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    entireNavController: NavHostController,
) {
    //TODO 임시 데이터
    val contents = listOf<Content>(
        Content(
            rank = 1,
            title = "광해",
            image = "https://i.namu.wiki/i/TqVoGq4Cs6XvdgZ5VbxTZPxBtVoksQC1ZWS8jJzrsCOFaFq88EmCF1ndlzn6OtCagRkUYv7E7ayjUzc2RMtXhA.webp",
            description = "왕이 된 남자"
        ),
        Content(
            rank = 2,
            title = "뽀로로",
            image = "https://i.namu.wiki/i/uxxXRrUEW7Nud72yH2YKsciBZGJD-XeJdkYSg5Jpp97kOwq5gESAuAHYeaqV9BJpzvHRaMOrDbEoN9U2B9RhZQ.webp",
            description = "뽀로로와 올 겨울을 함께 해요!"
        ),
        Content(
            rank = 3,
            title = "여신강림",
            image = "https://upload.wikimedia.org/wikipedia/ko/d/d7/%EC%97%AC%EC%8B%A0%EA%B0%95%EB%A6%BC_%EB%93%9C%EB%9D%BC%EB%A7%88_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg",
            description = "메이크업으로 여신이 된 주경이는 꿈과 사랑을 이룰 수 있을까?"
        ),
        Content(
            rank = 4,
            title = "신서유기",
            image = "https://i.namu.wiki/i/0-RXBLtGoNqcyV9TEiLD-ftdqS42a9jc5r29EsDcqMGENwCpFShtSfHfjxx4jliGnuy-wtnKZPtx2mCpi-lXaw.webp",
            description = "메이크업으로 여신이 된 주경이는 꿈과 사랑을 이룰 수 있을까?"
        ),
        Content(
            rank = 5,
            title = "사카모토입니다만?",
            image = "https://i.namu.wiki/i/iDjj7hRfDbp78k0XYmkqWtg5Hq5aa_uF0LTk3SiWzoZ5Rux01keM6VOtcD3QpIjH8KkLdhygVDejl54gnhkm4Q.webp",
            description = "Cool, Cooler, Coolest 고등학생 등장!"
        ),
    )
    var selectedTab by remember { mutableStateOf(HomeTabType.DRAMA) }
    val pagerState = rememberPagerState { contents.size }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        stickyHeader {
            MainStickyHeader(
                selectedTab = selectedTab,
                onSelected = { it -> selectedTab = it as HomeTabType },
                entireNavController = entireNavController,
            )
        }
        item {
            AtSoptContentViewPager(
                pagerState = pagerState,
                contents = contents,
                onClicked = { it -> },
                contentPadding = PaddingValues(horizontal = 15.dp),
            )
        }
        item {
            AtSoptContentRow(
                title = "오늘의 티빙 TOP 20",
                contents = contents,
                contentSize = Pair<Dp, Dp>(100.dp, 140.dp),
                onClicked = { it -> },
                showRank = true,
                modifier = Modifier
            )
        }
        item {
            AtSoptContentRow(
                title = "지금 방영 중인 콘텐츠",
                contents = contents,
                contentSize = Pair<Dp, Dp>(100.dp, 140.dp),
                onClicked = { it -> },
                showRank = false,
                modifier = Modifier
            )
        }
    }
}

@Composable
private fun MainStickyHeader(
    selectedTab: TabType,
    onSelected: (TabType) -> Unit,
    entireNavController: NavHostController,
)
{
    Column (
        modifier = Modifier.fillMaxWidth()
            .background(color = Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 20.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Text(text = "TVING", fontSize = 25.sp, color = Red40, fontWeight = FontWeight.Black)
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ){
                IconButton(
                    onClick = {
                        //TODO
                    },
                    modifier = Modifier.size(40.dp).padding(5.dp),
                    enabled = true
                ) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        imageVector = Icons.Filled.ConnectedTv,
                        tint = Color.White,
                        contentDescription = "chrome cast button"
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                IconButton(
                    onClick = {
                        //마이페이지로 이동(SAA)
                        entireNavController.navigate(MyPage)
                    },
                    modifier = Modifier.size(40.dp).padding(5.dp),
                    enabled = true
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.icon_tving),
                        contentDescription = "mypage button",
                        contentScale = ContentScale.Fit,
                    )
                }
            }
        }
        AtSoptTabBar(
            tabs = HomeTabType.entries,
            selectedTab = selectedTab,
            onSelected = onSelected,
            modifier = Modifier.fillMaxWidth().background(color = Color.Black).padding(start = 15.dp, end = 15.dp)
        )
    }
}
