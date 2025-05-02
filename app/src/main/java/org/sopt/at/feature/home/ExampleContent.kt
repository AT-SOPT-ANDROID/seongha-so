package org.sopt.at.feature.home

import org.sopt.at.domain.entity.Content

/*TODO: 임시데이터 이후 삭제 필요*/
class ExampleContent {
    companion object {
        val dramaContents = listOf<Content>(
            Content(
                rank = 1,
                title = "광해",
                image = "https://i.namu.wiki/i/TqVoGq4Cs6XvdgZ5VbxTZPxBtVoksQC1ZWS8jJzrsCOFaFq88EmCF1ndlzn6OtCagRkUYv7E7ayjUzc2RMtXhA.webp",
                description = "왕이 된 남자"
            ),
            Content(
                rank = 2,
                title = "뽀로로",
                image = "https://i.namu.wiki/i/uxxXRrUEW7Nud72yH2YKsciBZGJD-XeJdkYSg5Jpp97kOwq5gESAuAHYeaqV9BJpzvHRaMOrDbEoN9U2B9RhZQ.webp",
                description = "뽀로로와 올 겨울을 함께 해요!"
            ),
            Content(
                rank = 3,
                title = "여신강림",
                image = "https://upload.wikimedia.org/wikipedia/ko/d/d7/%EC%97%AC%EC%8B%A0%EA%B0%95%EB%A6%BC_%EB%93%9C%EB%9D%BC%EB%A7%88_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg",
                description = "메이크업으로 여신이 된 주경이는 꿈과 사랑을 이룰 수 있을까?"
            ),
            Content(
                rank = 4,
                title = "신서유기",
                image = "https://i.namu.wiki/i/0-RXBLtGoNqcyV9TEiLD-ftdqS42a9jc5r29EsDcqMGENwCpFShtSfHfjxx4jliGnuy-wtnKZPtx2mCpi-lXaw.webp",
                description = "나영석 PD의 인기 예능!"
            ),
            Content(
                rank = 5,
                title = "사카모토입니다만?",
                image = "https://i.namu.wiki/i/iDjj7hRfDbp78k0XYmkqWtg5Hq5aa_uF0LTk3SiWzoZ5Rux01keM6VOtcD3QpIjH8KkLdhygVDejl54gnhkm4Q.webp",
                description = "Cool, Cooler, Coolest 고등학생 등장!"
            ),
        )
        val entertainmentContents = listOf<Content>(
            Content(
                rank = 1,
                title = "신서유기",
                image = "https://i.namu.wiki/i/0-RXBLtGoNqcyV9TEiLD-ftdqS42a9jc5r29EsDcqMGENwCpFShtSfHfjxx4jliGnuy-wtnKZPtx2mCpi-lXaw.webp",
                description = "나영석 PD의 인기 예능!"
            ),
        )
        val movieContents = listOf<Content>(
            Content(
                rank = 1,
                title = "광해",
                image = "https://i.namu.wiki/i/TqVoGq4Cs6XvdgZ5VbxTZPxBtVoksQC1ZWS8jJzrsCOFaFq88EmCF1ndlzn6OtCagRkUYv7E7ayjUzc2RMtXhA.webp",
                description = "왕이 된 남자"
            ),
        )
        val sportsContents = listOf<Content>(
            Content(
                rank = 1,
                title = "비야인드",
                image = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250309/1001/P001768944.jpg/dims/resize/480",
                description = "본격 야구 뒷담화"
            ),
        )
        val animationContents = listOf<Content>(
            Content(
                rank = 1,
                title = "사카모토입니다만?",
                image = "https://i.namu.wiki/i/iDjj7hRfDbp78k0XYmkqWtg5Hq5aa_uF0LTk3SiWzoZ5Rux01keM6VOtcD3QpIjH8KkLdhygVDejl54gnhkm4Q.webp",
                description = "Cool, Cooler, Coolest 고등학생 등장!"
            ),
        )
        val newsContents = listOf<Content>(
            Content(
                rank = 1,
                title = "연합뉴스TV",
                image = "https://yt3.googleusercontent.com/ytc/AIdro_kFqbmXOoxJIaLVQYrJMB8gR8_LTF7Wm1lDpZbCmqhJh3U=s900-c-k-c0x00ffffff-no-rj",
                description = "실시간 뉴스 바로보기"
            ),
        )
    }
}