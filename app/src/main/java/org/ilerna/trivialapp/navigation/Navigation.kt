package org.ilerna.trivialapp.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.ilerna.trivialapp.view.MenuScreen
import org.ilerna.trivialapp.view.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = SplashScreen
    ) {
        composable<SplashScreen> {
            SplashScreen {
                navController.navigate(MenuScreen) {
                    popUpTo<SplashScreen> { inclusive = true }
                }
            }
        }
        composable<MenuScreen> {
            MenuScreen { difficulty ->
                navController.navigate(GameScreen(difficulty))
            }
        }
        composable<GameScreen> { backStackEntry ->
            val gameScreen = backStackEntry.toRoute<GameScreen>()
            // TODO: Implement GameScreen
            // For now, im just show a placeholder
            GameScreenPlaceholder(gameScreen.difficulty) {
                navController.navigate(MenuScreen) {
                    popUpTo<MenuScreen> { inclusive = true }
                }
            }
        }
    }
}

@Composable
fun GameScreenPlaceholder(difficulty: String, onBackToMenu: () -> Unit) {
    // temporary placeholder for the game screen
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Game Screen - Difficulty: $difficulty",
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onBackToMenu) {
            Text("Back to Menu")
        }
    }
}