package org.sopt.at.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import org.sopt.at.R
import org.sopt.at.core.tab.TabType
import org.sopt.at.domain.entity.Content
import org.sopt.at.ui.theme.Gray20
import org.sopt.at.ui.theme.Red40
import org.sopt.at.ui.theme.Transparent70

@Composable
fun AtSoptContentViewPager (
    pagerState: PagerState,
    contents: List<Content>,
    onClicked: (Content) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier.fillMaxWidth().height(500.dp),
    titleModifier: Modifier = Modifier,
){
    HorizontalPager(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        pageSpacing = 10.dp,
        state = pagerState,
        contentPadding = contentPadding,
    ) {
        page ->

        val content = contents[page]

        Box(
            modifier = Modifier.fillMaxSize()
                .clickable(onClick = {onClicked(content)}),
        ){
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(content.image)
                    .build(),
                contentDescription = content.description,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(R.drawable.content_default),
                error = painterResource(R.drawable.content_default),
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(10.dp)),
            )
            Box (
                modifier = Modifier.fillMaxWidth().height(120.dp)
                    .align(alignment = Alignment.BottomCenter)
                    .background(brush = Brush.verticalGradient(listOf(Color.Transparent, Transparent70)))
                    .clip(shape = RoundedCornerShape(10.dp)),
            ){
            }
            Column (
                modifier = Modifier.fillMaxWidth()
                    .padding(10.dp)
                    .align(alignment = Alignment.BottomCenter),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ){
                Text(
                    modifier = titleModifier,
                    text = content.title,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.White,
                )
                Text(
                    modifier = Modifier,
                    text = content.description,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                )
            }
        }
    }
}
