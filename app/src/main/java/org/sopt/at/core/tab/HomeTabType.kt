package org.sopt.at.core.tab

enum class HomeTabType(override val title: String): TabType{
    DRAMA("드라마"),
    ENTERTAINMENT("예능"),
    MOVIE("영화"),
    SPORTS("스포츠"),
    ANIMATION("애니"),
    NEWS("뉴스"),
}