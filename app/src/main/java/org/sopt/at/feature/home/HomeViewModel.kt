package org.sopt.at.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.at.core.tab.HomeTabType

class HomeViewModel: ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state

    fun onAction(action: HomeAction) {
        when (action) {
            is HomeAction.SelectTab -> {
                val contents = when (action.tab) {
                    HomeTabType.DRAMA -> ExampleContent.dramaContents
                    HomeTabType.ENTERTAINMENT -> ExampleContent.entertainmentContents
                    HomeTabType.MOVIE -> ExampleContent.movieContents
                    HomeTabType.SPORTS -> ExampleContent.sportsContents
                    HomeTabType.ANIMATION -> ExampleContent.animationContents
                    HomeTabType.NEWS -> ExampleContent.newsContents
                }
                _state.value = _state.value.copy(
                    selectedTab = action.tab,
                    contents = contents
                )
            }
        }
    }
}