package androidx.test.novelreader.ui.reader

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.RecordVoiceOver
import androidx.compose.material.icons.filled.TextDecrease
import androidx.compose.material.icons.filled.TextIncrease
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ReaderBottomBar(
    isDarkTheme: Boolean,
    isTtsPlaying: Boolean,
    onFontDecrease: () -> Unit,
    onFontIncrease: () -> Unit,
    onToggleTheme: () -> Unit,
    onToggleTts: () -> Unit,
    onVoiceSelection: () -> Unit,
    modifier: Modifier = Modifier
) {
    BottomAppBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Font size decrease
            IconButton(onClick = onFontDecrease) {
                Icon(
                    Icons.Default.TextDecrease,
                    contentDescription = "Decrease font size"
                )
            }

            // Font size increase
            IconButton(onClick = onFontIncrease) {
                Icon(
                    Icons.Default.TextIncrease,
                    contentDescription = "Increase font size"
                )
            }

            // Night mode toggle
            IconButton(onClick = onToggleTheme) {
                Icon(
                    if (isDarkTheme) Icons.Default.LightMode else Icons.Default.DarkMode,
                    contentDescription = if (isDarkTheme) "Light mode" else "Dark mode"
                )
            }

            // TTS play/pause
            FilledTonalIconButton(onClick = onToggleTts) {
                Icon(
                    if (isTtsPlaying) Icons.Default.Pause else Icons.AutoMirrored.Filled.VolumeUp,
                    contentDescription = if (isTtsPlaying) "Stop reading" else "Start reading"
                )
            }

            // Voice selection
            IconButton(onClick = onVoiceSelection) {
                Icon(
                    Icons.Default.RecordVoiceOver,
                    contentDescription = "Select voice"
                )
            }
        }
    }
}
