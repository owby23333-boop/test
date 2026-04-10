package androidx.test.novelreader.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.test.novelreader.ui.bookshelf.BookshelfScreen
import androidx.test.novelreader.ui.reader.ReaderScreen

@Composable
fun NovelReaderNavGraph(
    navController: NavHostController,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Bookshelf.route
    ) {
        composable(Screen.Bookshelf.route) {
            BookshelfScreen(
                onBookClick = { bookId ->
                    navController.navigate(Screen.Reader.createRoute(bookId))
                }
            )
        }

        composable(
            route = Screen.Reader.route,
            arguments = listOf(navArgument("bookId") { type = NavType.StringType })
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getString("bookId") ?: return@composable
            ReaderScreen(
                bookId = bookId,
                isDarkTheme = isDarkTheme,
                onToggleTheme = onToggleTheme,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
