package org.ilerna.trivialapp.model

/**
 * Data class representing a question in the trivia game.
 */
data class Question(
    val id: Int,
    val questionText: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val difficulty: String
)