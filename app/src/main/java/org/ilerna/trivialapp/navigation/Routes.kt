package org.ilerna.trivialapp.navigation

import kotlinx.serialization.Serializable

@Serializable
object MenuScreen

@Serializable
data class GameScreen(val difficulty: String)

@Serializable
data class ResultScreen(val correctAnswers: Int, val totalQuestions: Int, val difficulty: String)