package org.sopt.at.feature.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.History
import org.sopt.at.core.navigation.Home
import org.sopt.at.core.navigation.Live
import org.sopt.at.core.navigation.Search
import org.sopt.at.core.navigation.Shorts
import org.sopt.at.feature.history.HistoryScreen
import org.sopt.at.feature.home.HomeScreen
import org.sopt.at.feature.live.LiveScreen
import org.sopt.at.feature.mypage.MyPage
import org.sopt.at.feature.mypage.MyScreen
import org.sopt.at.feature.search.SearchScreen
import org.sopt.at.feature.shorts.ShortsScreen

@Composable
fun EntireNavHost(
    navController: NavHostController,
    viewModel: MainViewModel,
) {
    NavHost(
    navController = navController,
    startDestination = Main,
    ) {
        composable<MyPage> {
            MyScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable<Main> {
            MainScreen(
                entireNavController = navController,
                viewModel = viewModel
            )
        }
    }
}