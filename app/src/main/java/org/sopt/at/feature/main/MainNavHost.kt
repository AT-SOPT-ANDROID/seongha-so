package org.sopt.at.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import org.sopt.at.feature.search.SearchScreen
import org.sopt.at.feature.shorts.ShortsScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Home,
        modifier = modifier
    ) {
        composable<Home> { HomeScreen() }
        composable<Shorts> { ShortsScreen() }
        composable<Live> { LiveScreen() }
        composable<Search> { SearchScreen() }
        composable<History> { HistoryScreen() }
    }
}
