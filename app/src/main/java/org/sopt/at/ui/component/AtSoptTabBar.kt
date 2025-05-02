package org.sopt.at.ui.component

import NoRippleInteractionSource
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import org.sopt.at.core.tab.HomeTabType
import org.sopt.at.core.tab.TabType
import org.sopt.at.ui.theme.Gray20

@Composable
fun AtSoptTabBar (
    tabs: List<TabType>,
    selectedTab: TabType,
    onSelected: (TabType) -> Unit,
    modifier: Modifier = Modifier,
){
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        items(tabs) { tabType ->
            Text(
                text = tabType.title,
                color = if (selectedTab == tabType) Color.White else Gray20,
                fontWeight = if (selectedTab == tabType) FontWeight.Bold else FontWeight.Light,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable(
                        onClick = { onSelected(tabType) },
                        interactionSource = NoRippleInteractionSource(),
                        indication = null
                    )
            )
        }
    }
}