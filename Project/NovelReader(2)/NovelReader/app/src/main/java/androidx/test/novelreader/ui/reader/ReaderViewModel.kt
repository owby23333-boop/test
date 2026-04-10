package androidx.test.novelreader.ui.reader

import android.app.Application
import android.content.Intent
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.speech.tts.Voice
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.test.novelreader.data.local.AppDatabase
import androidx.test.novelreader.data.model.Book
import androidx.test.novelreader.data.repository.BookRepository
import androidx.test.novelreader.parser.BookContent
import androidx.test.novelreader.service.TtsService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Locale

data class ReaderUiState(
    val book: Book? = null,
    val content: BookContent? = null,
    val fontSize: Float = 18f,
    val isLoading: Boolean = true,
    val error: String? = null,
    val isTtsPlaying: Boolean = false,
    val currentTtsSentence: Int = -1,
    val availableVoices: List<Voice> = emptyList(),
    val selectedVoice: Voice? = null,
    val showVoiceSheet: Boolean = false,
    val showControls: Boolean = true
)

class ReaderViewModel(
    application: Application,
    savedStateHandle: SavedStateHandle
) : AndroidViewModel(application), TextToSpeech.OnInitListener {

    private val bookId: String = savedStateHandle["bookId"] ?: ""

    private val repository = BookRepository(
        database = AppDatabase.getInstance(application),
        contentResolver = application.contentResolver
    )

    private val _uiState = MutableStateFlow(ReaderUiState())
    val uiState: StateFlow<ReaderUiState> = _uiState.asStateFlow()

    private var tts: TextToSpeech? = null
    private var ttsInitialized = false

    init {
        tts = TextToSpeech(application, this)
        loadBook()
    }

    private fun loadBook() {
        viewModelScope.launch {
            try {
                val book = repository.getBook(bookId)
                if (book == null) {
                    _uiState.update { it.copy(isLoading = false, error = "Book not found") }
                    return@launch
                }

                _uiState.update { it.copy(book = book) }

                val content = repository.getBookContent(book)
                _uiState.update { it.copy(
                    content = content,
                    isLoading = false,
                    currentTtsSentence = if (book.lastTtsPosition > 0) book.lastTtsPosition else -1
                ) }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = "Failed to load: ${e.message}") }
            }
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            ttsInitialized = true
            tts?.language = Locale.CHINA

            val voices = tts?.voices
                ?.filter { it.locale.language == Locale.CHINESE.language || it.locale.language == "en" }
                ?.sortedBy { it.name }
                ?: emptyList()

            _uiState.update { it.copy(availableVoices = voices) }
        }
    }

    fun toggleControls() {
        _uiState.update { it.copy(showControls = !it.showControls) }
    }

    fun adjustFontSize(delta: Float) {
        _uiState.update {
            it.copy(fontSize = (it.fontSize + delta).coerceIn(12f, 36f))
        }
    }

    fun toggleTts() {
        val state = _uiState.value
        if (state.isTtsPlaying) {
            stopTts()
        } else {
            startTts()
        }
    }

    private fun startTts() {
        val state = _uiState.value
        val sentences = state.content?.sentences ?: return
        if (!ttsInitialized || sentences.isEmpty()) return

        val startIndex = if (state.currentTtsSentence >= 0) state.currentTtsSentence else 0

        tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {
                val index = utteranceId?.removePrefix("s_")?.toIntOrNull() ?: return
                _uiState.update { it.copy(currentTtsSentence = index) }
            }

            override fun onDone(utteranceId: String?) {
                val index = utteranceId?.removePrefix("s_")?.toIntOrNull() ?: return
                val nextIndex = index + 1
                if (nextIndex < sentences.size) {
                    speakSentence(nextIndex, sentences)
                } else {
                    _uiState.update { it.copy(isTtsPlaying = false, currentTtsSentence = -1) }
                    stopTtsService()
                }
            }

            override fun onError(utteranceId: String?) {
                _uiState.update { it.copy(isTtsPlaying = false) }
                stopTtsService()
            }
        })

        _uiState.update { it.copy(isTtsPlaying = true, currentTtsSentence = startIndex) }
        speakSentence(startIndex, sentences)
        startTtsService()
    }

    private fun speakSentence(index: Int, sentences: List<String>) {
        if (index >= sentences.size) return
        tts?.speak(sentences[index], TextToSpeech.QUEUE_FLUSH, null, "s_$index")
    }

    fun stopTts() {
        tts?.stop()
        saveTtsProgress()
        _uiState.update { it.copy(isTtsPlaying = false) }
        stopTtsService()
    }

    fun selectVoice(voice: Voice) {
        tts?.voice = voice
        _uiState.update { it.copy(selectedVoice = voice, showVoiceSheet = false) }
    }

    fun showVoiceSelection() {
        _uiState.update { it.copy(showVoiceSheet = true) }
    }

    fun hideVoiceSelection() {
        _uiState.update { it.copy(showVoiceSheet = false) }
    }

    fun saveReadProgress(scrollFraction: Float) {
        val book = _uiState.value.book ?: return
        viewModelScope.launch {
            repository.updateReadProgress(book.id, scrollFraction)
        }
    }

    private fun saveTtsProgress() {
        val book = _uiState.value.book ?: return
        val sentenceIndex = _uiState.value.currentTtsSentence
        if (sentenceIndex >= 0) {
            viewModelScope.launch {
                repository.updateTtsProgress(book.id, sentenceIndex)
            }
        }
    }

    private fun startTtsService() {
        val app = getApplication<Application>()
        val intent = Intent(app, TtsService::class.java).apply {
            putExtra("bookTitle", _uiState.value.book?.title ?: "Reading")
        }
        app.startService(intent)
    }

    private fun stopTtsService() {
        val app = getApplication<Application>()
        app.stopService(Intent(app, TtsService::class.java))
    }

    override fun onCleared() {
        if (_uiState.value.isTtsPlaying) {
            saveTtsProgress()
        }
        tts?.stop()
        tts?.shutdown()
        tts = null
        super.onCleared()
    }
}
