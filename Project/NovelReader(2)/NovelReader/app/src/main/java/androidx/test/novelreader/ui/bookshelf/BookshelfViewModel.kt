package androidx.test.novelreader.ui.bookshelf

import android.app.Application
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.test.novelreader.data.local.AppDatabase
import androidx.test.novelreader.data.model.Book
import androidx.test.novelreader.data.repository.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class BookshelfViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = BookRepository(
        database = AppDatabase.getInstance(application),
        contentResolver = application.contentResolver
    )

    val books: StateFlow<List<Book>> = repository.allBooks
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _snackbarMessage = MutableStateFlow<String?>(null)
    val snackbarMessage: StateFlow<String?> = _snackbarMessage.asStateFlow()

    fun importBook(uri: Uri) {
        // Take persistable permission so we can read the file later
        try {
            getApplication<Application>().contentResolver.takePersistableUriPermission(
                uri, Intent.FLAG_GRANT_READ_URI_PERMISSION
            )
        } catch (_: SecurityException) {
            // Some providers don't support persistable permissions
        }

        viewModelScope.launch {
            _isLoading.value = true
            try {
                repository.importBook(uri)
                _snackbarMessage.value = "Book imported successfully"
            } catch (e: Exception) {
                _snackbarMessage.value = "Failed to import: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun deleteBook(bookId: String) {
        viewModelScope.launch {
            try {
                repository.deleteBook(bookId)
                _snackbarMessage.value = "Book removed"
            } catch (e: Exception) {
                _snackbarMessage.value = "Failed to remove: ${e.message}"
            }
        }
    }

    fun clearSnackbar() {
        _snackbarMessage.value = null
    }
}
