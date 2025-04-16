package org.sopt.at.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import kotlinx.serialization.Serializable
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
