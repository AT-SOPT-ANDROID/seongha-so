package org.sopt.at.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.request.ImageResult
import org.sopt.at.R
import org.sopt.at.core.tab.TabType
import org.sopt.at.domain.entity.Content
import org.sopt.at.ui.theme.Gray20

@Composable
fun AtSoptContentRow (
    title: String,
    contents: List<Content>,
    contentSize: Pair<Dp, Dp>,
    onSelected: (Content) -> Unit,
    showRank: Boolean = false,
    modifier: Modifier,
){
    Text(
        text = title,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 15.dp, bottom = 10.dp),
    )
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(horizontal = 15.dp)
    ) {
        items(contents) { cotent ->
            AtSoptContentContainer(
                content = cotent,
                contentSize = contentSize,
                onSelected = onSelected,
                showRank = showRank,
            )
        }
    }
}

@Composable
private fun AtSoptContentContainer(
    content: Content,
    contentSize: Pair<Dp, Dp>,
    onSelected: (Content) -> Unit,
    showRank: Boolean = false,
    modifier: Modifier = Modifier
){
    Row(
       modifier = modifier.fillMaxHeight(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ){
        if(showRank) {
            Text(
                text = content.rank.toString(),
                modifier = Modifier.align(Alignment.Bottom).padding(end = 2.dp),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        }
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(content.image)
                .build(),
            contentDescription = content.description,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.content_default),
            error = painterResource(R.drawable.content_default),
            modifier = Modifier
                .size(width = contentSize.first, height = contentSize.second)
                .clip(shape = RoundedCornerShape(5.dp))
                .clickable(onClick = {onSelected(content)}),
        )
    }
}