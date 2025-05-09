package org.sopt.at.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.rememberCoroutineScope
import org.sopt.at.core.tab.HomeTabType

@Composable
fun HomeSideEffects(onAction: (HomeAction) -> Unit) {
    LaunchedEffect(Unit) {
        onAction(HomeAction.SelectTab(HomeTabType.DRAMA))
    }

}