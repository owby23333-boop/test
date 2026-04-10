package androidx.test.novelreader.ui.reader

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReaderScreen(
    bookId: String,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    onNavigateBack: () -> Unit,
    viewModel: ReaderViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val scrollState = rememberScrollState()

    // Save progress when leaving
    DisposableEffect(Unit) {
        onDispose {
            if (scrollState.maxValue > 0) {
                viewModel.saveReadProgress(scrollState.value.toFloat() / scrollState.maxValue)
            }
            if (uiState.isTtsPlaying) {
                viewModel.stopTts()
            }
        }
    }

    // Restore scroll position
    LaunchedEffect(uiState.content) {
        val book = uiState.book ?: return@LaunchedEffect
        if (book.lastReadPosition > 0f && scrollState.maxValue > 0) {
            scrollState.scrollTo((book.lastReadPosition * scrollState.maxValue).toInt())
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when {
            uiState.isLoading -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
            uiState.error != null -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        text = uiState.error!!,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
            uiState.content != null -> {
                Column(modifier = Modifier.fillMaxSize()) {
                    // Top bar
                    AnimatedVisibility(
                        visible = uiState.showControls,
                        enter = slideInVertically { -it },
                        exit = slideOutVertically { -it }
                    ) {
                        TopAppBar(
                            title = {
                                Text(
                                    text = uiState.book?.title ?: "",
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            },
                            navigationIcon = {
                                IconButton(onClick = onNavigateBack) {
                                    Icon(
                                        Icons.AutoMirrored.Filled.ArrowBack,
                                        contentDescription = "Back"
                                    )
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.surfaceContainer
                            )
                        )
                    }

                    // Content area - tap to toggle controls
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                viewModel.toggleControls()
                            }
                    ) {
                        ReaderContent(
                            content = uiState.content!!,
                            fontSize = uiState.fontSize,
                            highlightSentenceIndex = uiState.currentTtsSentence,
                            scrollState = scrollState,
                            isDarkTheme = isDarkTheme
                        )
                    }

                    // Bottom bar
                    AnimatedVisibility(
                        visible = uiState.showControls,
                        enter = slideInVertically { it },
                        exit = slideOutVertically { it }
                    ) {
                        ReaderBottomBar(
                            isDarkTheme = isDarkTheme,
                            isTtsPlaying = uiState.isTtsPlaying,
                            onFontDecrease = { viewModel.adjustFontSize(-2f) },
                            onFontIncrease = { viewModel.adjustFontSize(2f) },
                            onToggleTheme = onToggleTheme,
                            onToggleTts = { viewModel.toggleTts() },
                            onVoiceSelection = { viewModel.showVoiceSelection() }
                        )
                    }
                }

                // Voice selection bottom sheet
                if (uiState.showVoiceSheet) {
                    VoiceSelectionSheet(
                        voices = uiState.availableVoices,
                        selectedVoice = uiState.selectedVoice,
                        onSelectVoice = { viewModel.selectVoice(it) },
                        onDismiss = { viewModel.hideVoiceSelection() }
                    )
                }
            }
        }
    }
}
