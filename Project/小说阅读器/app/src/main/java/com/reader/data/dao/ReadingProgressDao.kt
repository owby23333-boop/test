package com.reader.data.dao

import androidx.room.*
import com.reader.data.model.ReadingProgress
import kotlinx.coroutines.flow.Flow

@Dao
interface ReadingProgressDao {

    @Query("SELECT * FROM reading_progress WHERE bookId = :bookId ORDER BY lastReadTime DESC")
    fun getProgressByBook(bookId: String): Flow<List<ReadingProgress>>

    @Query("SELECT * FROM reading_progress ORDER BY lastReadTime DESC LIMIT 5")
    fun getRecentReading(): Flow<List<ReadingProgress>>

    @Query("SELECT * FROM reading_progress WHERE progressPercent < 100 ORDER BY lastReadTime DESC LIMIT 5")
    fun getUnfinishedBooks(): Flow<List<ReadingProgress>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(progress: ReadingProgress): Long

    @Update
    suspend fun update(progress: ReadingProgress)

    @Delete
    suspend fun delete(progress: ReadingProgress)

    @Query("SELECT * FROM reading_progress WHERE id = :id")
    suspend fun getProgressById(id: Int): ReadingProgress?

    @Query("DELETE FROM reading_progress WHERE bookId = :bookId")
    suspend fun deleteByBook(bookId: String)

    @Query("SELECT * FROM reading_progress WHERE chapterId = :chapterId")
    suspend fun getProgressByChapter(chapterId: String): ReadingProgress?

    @Query("SELECT COUNT(*) FROM reading_progress")
    suspend fun getTotalProgressCount(): Int

    @Query("SELECT SUM(progressPercent) FROM reading_progress")
    suspend fun getTotalReadPages(): Int?
}