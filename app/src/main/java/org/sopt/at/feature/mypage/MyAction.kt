package org.sopt.at.feature.mypage

sealed class MyAction {
    data class LoadNickname(val userId: Long) : MyAction()
}