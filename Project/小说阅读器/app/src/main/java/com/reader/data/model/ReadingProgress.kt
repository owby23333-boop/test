package com.reader.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reading_progress")
data class ReadingProgress(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val bookId: String,
    val chapterId: String,
    val chapterTitle: String,
    val progressPercent: Int,
    val contentOffset: Int,
    val lastReadTime: Long,
    val isBookmarked: Boolean = false,
    val notes: String? = null
)