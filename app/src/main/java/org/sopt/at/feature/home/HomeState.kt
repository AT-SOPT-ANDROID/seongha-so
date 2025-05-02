package org.sopt.at.feature.home

import org.sopt.at.core.tab.HomeTabType
import org.sopt.at.domain.entity.Content

data class HomeState (
    val selectedTab: HomeTabType = HomeTabType.DRAMA,
    val contents: List<Content> = ExampleContent.dramaContents
)