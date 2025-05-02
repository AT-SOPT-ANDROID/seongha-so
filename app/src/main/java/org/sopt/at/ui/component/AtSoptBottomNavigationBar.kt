package org.sopt.at.ui.component

import NoRippleInteractionSource
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.collections.immutable.ImmutableList
import org.sopt.at.R
import org.sopt.at.core.navigation.NavRoute
import org.sopt.at.core.navigation.NavRouteData

@Composable
fun AtSoptBottomNavigationBar (
    navController: NavHostController,
    tabs: ImmutableList<NavRouteData<NavRoute>>,
    modifier: Modifier,
    colors: NavigationBarItemColors = NavigationBarItemDefaults.colors(),
){
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination
    val context = LocalContext.current

    NavigationBar(
        modifier = modifier,
        containerColor = Color.Black,
    ) {
        tabs.forEach { screen ->
            val label = screen.route::class.simpleName ?: context.getString(R.string.tab_default)
            NavigationBarItem(
                selected = currentDestination?.route == screen.route::class.qualifiedName,
                onClick = {
                    navController.navigate(screen.route)
                },
                interactionSource = NoRippleInteractionSource(),
                label = { Text(label) },
                icon = {
                    Icon(screen.icon, contentDescription = label)
                },
                colors = colors
            )
        }
    }
}