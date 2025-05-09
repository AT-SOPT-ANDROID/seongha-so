package org.sopt.at.feature.home

import androidx.compose.runtime.Immutable
import org.sopt.at.core.tab.HomeTabType

@Immutable
sealed class HomeAction {
    data class SelectTab(val tab: HomeTabType): HomeAction()
}