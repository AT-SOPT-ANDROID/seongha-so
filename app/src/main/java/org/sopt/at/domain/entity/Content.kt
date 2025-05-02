package org.sopt.at.domain.entity

import androidx.compose.runtime.Immutable

@Immutable
data class Content (
    val rank: Int,
    val title: String,
    val image: String,
    val description: String,
)