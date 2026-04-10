package androidx.test.novelreader.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class BookEntity(
    @PrimaryKey val id: String,
    val title: String,
    val author: String,
    val uri: String,
    val type: String,
    val coverColor: Int,
    val lastReadPosition: Float = 0f,
    val lastTtsPosition: Int = 0,
    val lastReadTime: Long = System.currentTimeMillis(),
    val addedTime: Long = System.currentTimeMillis()
)
