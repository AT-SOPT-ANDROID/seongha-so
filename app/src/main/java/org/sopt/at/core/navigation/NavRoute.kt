package org.sopt.at.core.navigation

import androidx.compose.ui.graphics.vector.ImageVector

interface NavRoute

data class NavRouteData<T: NavRoute>(
    val route: T,
    val icon: ImageVector
)