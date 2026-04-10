package com.reader.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.reader.navigation.Screen
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainActivity(
    navController: NavController = rememberNavController()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "📖 小说阅读器") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Book, "书架") },
                    label = { Text("📚") },
                    selected = true,
                    onClick = { navController.navigate(Screen.Library) }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Settings, "设置") },
                    label = { Text("⚙️") },
                    onClick = { navController.navigate(Screen.Settings) }
                )
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Library.route
        ) {
            composable(Screen.Library.route) {
                Library()
            }

            composable(Screen.Reading.route) {
                ReadingPage()
            }

            composable(Screen.Tts.route) {
                TtsActivity()
            }

            composable(Screen.Settings.route) {
                SettingsActivity()
            }
        }
    }
}

@Preview
@Composable
fun PreviewMainActivity() {
    MaterialTheme {
        MainActivity()
    }
}