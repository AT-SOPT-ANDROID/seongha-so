package org.sopt.at.feature.home

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import org.sopt.at.core.tab.HomeTabType
import org.sopt.at.domain.entity.Content

@Immutable
data class HomeState (
    val selectedTab: HomeTabType = HomeTabType.DRAMA,
    val contents: ImmutableList<Content> = ExampleContent.dramaContents
)
