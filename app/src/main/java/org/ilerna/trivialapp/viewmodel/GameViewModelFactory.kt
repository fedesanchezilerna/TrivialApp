package org.ilerna.trivialapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Factory for creating GameViewModel instances.
 * Used to create the GameViewModel with the difficulty.
 */
class GameViewModelFactory(
    private val difficulty: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
            return GameViewModel(difficulty) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}