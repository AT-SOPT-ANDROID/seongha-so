package org.sopt.at.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.at.ui.theme.Gray0

@Composable
fun ReturnBar (
){
    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 10.dp, start = 10.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier.align(Alignment.Start).size(25.dp),
            enabled = true
        ) {
            Icon(
                modifier = Modifier,
                imageVector = Icons.Filled.ArrowBackIosNew,
                tint = Gray0,
                contentDescription = null
            )
        }
    }
}