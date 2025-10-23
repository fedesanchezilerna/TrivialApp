package org.ilerna.trivialapp.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.ilerna.trivialapp.view.GameScreen
import org.ilerna.trivialapp.view.MenuScreen
import org.ilerna.trivialapp.view.ResultScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = MenuScreen
    ) {
        composable<MenuScreen> {
            MenuScreen { difficulty ->
                navController.navigate(GameScreen(difficulty))
            }
        }
        composable<GameScreen> { backStackEntry ->
            val gameScreen = backStackEntry.toRoute<GameScreen>()
            GameScreen(
                difficulty = gameScreen.difficulty,
                onGameFinished = { correctAnswers, totalQuestions ->
                    navController.navigate(
                        ResultScreen(
                            correctAnswers,
                            totalQuestions,
                            gameScreen.difficulty
                        )
                    ) {
                        popUpTo<GameScreen> { inclusive = true }
                    }
                },
                onBackToMenu = {
                    navController.navigate(MenuScreen) {
                        popUpTo<MenuScreen> { inclusive = true }
                    }
                }
            )
        }
        composable<ResultScreen> { backStackEntry ->
            val resultScreen = backStackEntry.toRoute<ResultScreen>()
            ResultScreen(
                correctAnswers = resultScreen.correctAnswers,
                totalQuestions = resultScreen.totalQuestions,
                difficulty = resultScreen.difficulty,
                onShare = {
                    val shareText =
                        "Puntaje final :) \n${resultScreen.correctAnswers}/${resultScreen.totalQuestions}"
                    val shareIntent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, shareText)
                        type = "text/plain"
                    }
                    context.startActivity(Intent.createChooser(shareIntent, "Compartir puntaje"))
                },
                onBackToMenu = {
                    navController.navigate(MenuScreen) {
                        popUpTo<MenuScreen> { inclusive = true }
                    }
                }
            )
        }
    }
}

