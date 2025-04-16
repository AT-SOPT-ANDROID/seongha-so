package org.sopt.at.feature.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.sopt.at.core.navigation.NavRoute
import org.sopt.at.core.navigation.NavRouteData
import org.sopt.at.ui.component.AtSoptBottomNavigationBar
import org.sopt.at.ui.theme.Gray40

@Composable
fun MainScreen(
    navController: NavHostController,
    tabs: List<NavRouteData<NavRoute>>,
) {
    Scaffold(
        bottomBar = {
            AtSoptBottomNavigationBar(
                navController = navController,
                tabs = tabs,
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                colors = NavigationBarItemColors(
                    selectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    selectedIndicatorColor = Color.Transparent,
                    unselectedIconColor = Gray40,
                    unselectedTextColor = Gray40,
                    disabledTextColor = Gray40,
                    disabledIconColor = Gray40
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        )
        {
            MainNavHost(
                navController = navController,
                modifier = Modifier
            )
        }
    }
}