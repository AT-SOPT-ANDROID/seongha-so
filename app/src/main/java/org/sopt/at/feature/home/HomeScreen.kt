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
import org.sopt.at.feature.onboarding.SignUpStep
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
    var selectedTab by remember { mutableStateOf(HomeTabType.DRAMA) }
    val contents = when(selectedTab){
        HomeTabType.DRAMA -> ExampleContent.dramaContents
        HomeTabType.ENTERTAINMENT -> ExampleContent.entertainmentContents
        HomeTabType.MOVIE -> ExampleContent.movieContents
        HomeTabType.SPORTS -> ExampleContent.sportsContents
        HomeTabType.ANIMATION -> ExampleContent.animationContents
        HomeTabType.NEWS -> ExampleContent.newsContents
    }
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
