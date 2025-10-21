package org.ilerna.trivialapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Factory for creating ResultViewModel instances.
 * Used to create the ResultViewModel with the correct answers, total questions and difficulty.
 */
class ResultViewModelFactory(
    private val correctAnswers: Int,
    private val totalQuestions: Int,
    private val difficulty: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResultViewModel::class.java)) {
            return ResultViewModel(correctAnswers, totalQuestions, difficulty) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}