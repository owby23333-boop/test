package androidx.test.novelreader.parser

data class BookContent(
    val fullText: String,
    val sentences: List<String>,
    val chapters: List<Chapter> = emptyList()
)

data class Chapter(
    val title: String,
    val startCharIndex: Int,
    val content: String
)
