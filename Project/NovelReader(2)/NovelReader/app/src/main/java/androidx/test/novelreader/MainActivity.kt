package androidx.test.novelreader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import androidx.test.novelreader.ui.navigation.NovelReaderNavGraph
import androidx.test.novelreader.ui.theme.NovelReaderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var darkThemeOverride by rememberSaveable { mutableStateOf<Boolean?>(null) }
            val isDarkTheme = darkThemeOverride ?: isSystemInDarkTheme()

            NovelReaderTheme(darkTheme = isDarkTheme) {
                val navController = rememberNavController()
                NovelReaderNavGraph(
                    navController = navController,
                    isDarkTheme = isDarkTheme,
                    onToggleTheme = {
                        darkThemeOverride = !isDarkTheme
                    }
                )
            }
        }
    }
}
