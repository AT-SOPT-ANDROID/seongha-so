package org.sopt.at.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PhoneIphone
import androidx.compose.material.icons.filled.SatelliteAlt
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.serialization.Serializable

@Serializable
sealed interface MainNavRoute: NavRoute

@Serializable
data object Home : MainNavRoute
@Serializable
data object Shorts : MainNavRoute
@Serializable
data object Live : MainNavRoute
@Serializable
data object Search : MainNavRoute
@Serializable
data object History : MainNavRoute

@Immutable
object MainNavRoutes {
    val tabs: ImmutableList<NavRouteData<NavRoute>> = persistentListOf(
        NavRouteData(Home, Icons.Filled.Home),
        NavRouteData(Shorts, Icons.Filled.PhoneIphone),
        NavRouteData(Live, Icons.Filled.SatelliteAlt),
        NavRouteData(Search, Icons.Filled.Search),
        NavRouteData(History, Icons.Filled.AccessTime)
    )
}