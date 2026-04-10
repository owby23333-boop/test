package com.reader.navigation

sealed class Screen(val route: String) {
    object Library : Screen("library")
    object Reading : Screen("reading")
    object Tts : Screen("tts")
    object Settings : Screen("settings")
}