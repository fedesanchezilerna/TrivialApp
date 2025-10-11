package org.ilerna.trivialapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.ilerna.trivialapp.view.MenuScreen
import org.ilerna.trivialapp.view.ResultScreen
import org.ilerna.trivialapp.view.GameScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
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
                    navController.navigate(ResultScreen(correctAnswers, totalQuestions, gameScreen.difficulty)) {
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
                    // TODO: Implementar funcion share
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

