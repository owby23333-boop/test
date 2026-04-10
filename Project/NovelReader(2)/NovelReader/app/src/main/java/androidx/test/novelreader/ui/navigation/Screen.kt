package androidx.test.novelreader.ui.navigation

sealed class Screen(val route: String) {
    data object Bookshelf : Screen("bookshelf")
    data object Reader : Screen("reader/{bookId}") {
        fun createRoute(bookId: String) = "reader/$bookId"
    }
}
