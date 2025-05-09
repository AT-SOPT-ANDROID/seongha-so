package org.sopt.at.core.tab

import androidx.compose.ui.platform.LocalContext
import org.sopt.at.R

enum class HomeTabType(override val title: Int): TabType{
    DRAMA(R.string.home_tab_type_drama),
    ENTERTAINMENT(R.string.home_tab_type_entertainment),
    MOVIE(R.string.home_tab_type_movie),
    SPORTS(R.string.home_tab_type_sports),
    ANIMATION(R.string.home_tab_type_animation),
    NEWS(R.string.home_tab_type_news),
}