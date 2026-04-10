package androidx.test.novelreader.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Query("SELECT * FROM books ORDER BY lastReadTime DESC")
    fun getAllBooks(): Flow<List<BookEntity>>

    @Query("SELECT * FROM books WHERE id = :id")
    suspend fun getBookById(id: String): BookEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(book: BookEntity)

    @Query("DELETE FROM books WHERE id = :id")
    suspend fun deleteBook(id: String)

    @Query("UPDATE books SET lastReadPosition = :position, lastReadTime = :time WHERE id = :id")
    suspend fun updateReadProgress(id: String, position: Float, time: Long = System.currentTimeMillis())

    @Query("UPDATE books SET lastTtsPosition = :ttsPos, lastReadTime = :time WHERE id = :id")
    suspend fun updateTtsProgress(id: String, ttsPos: Int, time: Long = System.currentTimeMillis())
}
