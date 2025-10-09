package org.ilerna.trivialapp.navigation

import kotlinx.serialization.Serializable

@Serializable
object SplashScreen

@Serializable
object MenuScreen

@Serializable
data class GameScreen(val difficulty: String)