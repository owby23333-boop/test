package androidx.test.novelreader.data.repository

import android.content.ContentResolver
import android.net.Uri
import android.provider.OpenableColumns
import androidx.test.novelreader.data.local.AppDatabase
import androidx.test.novelreader.data.local.BookEntity
import androidx.test.novelreader.data.model.Book
import androidx.test.novelreader.data.model.BookType
import androidx.test.novelreader.parser.BookContent
import androidx.test.novelreader.parser.EpubParser
import androidx.test.novelreader.parser.TxtParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.util.UUID

class BookRepository(
    private val database: AppDatabase,
    private val contentResolver: ContentResolver
) {
    private val dao = database.bookDao()

    val allBooks: Flow<List<Book>> = dao.getAllBooks().map { entities ->
        entities.map { it.toDomain() }
    }

    suspend fun getBook(id: String): Book? {
        return dao.getBookById(id)?.toDomain()
    }

    suspend fun importBook(uri: Uri): Book {
        val displayName = getDisplayName(uri) ?: "Unknown"
        val type = when {
            displayName.endsWith(".epub", ignoreCase = true) -> BookType.EPUB
            else -> BookType.TXT
        }
        val title = displayName.substringBeforeLast(".")
        val coverColor = generateCoverColor(title)

        val entity = BookEntity(
            id = UUID.randomUUID().toString(),
            title = title,
            author = "Unknown",
            uri = uri.toString(),
            type = type.name,
            coverColor = coverColor,
            lastReadTime = System.currentTimeMillis(),
            addedTime = System.currentTimeMillis()
        )
        dao.insertBook(entity)
        return entity.toDomain()
    }

    suspend fun getBookContent(book: Book): BookContent = withContext(Dispatchers.IO) {
        val inputStream = contentResolver.openInputStream(Uri.parse(book.uri))
            ?: throw IllegalStateException("Cannot open file: ${book.uri}")

        inputStream.use { stream ->
            when (book.type) {
                BookType.TXT -> TxtParser.parse(stream)
                BookType.EPUB -> EpubParser.parse(stream)
            }
        }
    }

    suspend fun updateReadProgress(bookId: String, position: Float) {
        dao.updateReadProgress(bookId, position)
    }

    suspend fun updateTtsProgress(bookId: String, ttsPosition: Int) {
        dao.updateTtsProgress(bookId, ttsPosition)
    }

    suspend fun deleteBook(bookId: String) {
        dao.deleteBook(bookId)
    }

    private fun getDisplayName(uri: Uri): String? {
        contentResolver.query(uri, null, null, null, null)?.use { cursor ->
            if (cursor.moveToFirst()) {
                val index = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                if (index >= 0) return cursor.getString(index)
            }
        }
        return uri.lastPathSegment
    }

    private fun generateCoverColor(title: String): Int {
        val colors = intArrayOf(
            0xFF6750A4.toInt(), // Purple
            0xFF625B71.toInt(), // PurpleGrey
            0xFF7D5260.toInt(), // Pink
            0xFF006C51.toInt(), // Green
            0xFF00658E.toInt(), // Blue
            0xFF984061.toInt(), // Rose
            0xFF5C6300.toInt(), // Olive
            0xFF8B5000.toInt(), // Orange
        )
        return colors[title.hashCode().and(0x7FFFFFFF) % colors.size]
    }

    private fun BookEntity.toDomain() = Book(
        id = id,
        title = title,
        author = author,
        uri = uri,
        type = BookType.valueOf(type),
        coverColor = coverColor,
        lastReadPosition = lastReadPosition,
        lastTtsPosition = lastTtsPosition,
        lastReadTime = lastReadTime,
        addedTime = addedTime
    )
}
