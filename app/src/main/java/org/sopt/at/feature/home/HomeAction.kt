package org.sopt.at.feature.home

import org.sopt.at.core.navigation.MainNavRoutes
import org.sopt.at.core.tab.HomeTabType

sealed class HomeAction {
    data class SelectTab(val tab: HomeTabType): HomeAction()
}