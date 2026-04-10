package com.reader.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Book(
    @PrimaryKey val id: String,
    val title: String,
    val author: String,
    val coverUrl: String?,
    val totalChapters: Int,
    val lastReadChapter: Int,
    val lastReadProgress: Int,
    val isFavorite: Boolean = false
)