package androidx.test.novelreader.data.model

data class Book(
    val id: String,
    val title: String,
    val author: String,
    val uri: String,
    val type: BookType,
    val coverColor: Int,
    val lastReadPosition: Float = 0f,
    val lastTtsPosition: Int = 0,
    val lastReadTime: Long = 0L,
    val addedTime: Long = 0L
)
