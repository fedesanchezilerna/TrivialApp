package org.ilerna.trivialapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ViewModel for the result screen.
 * Handles the result logic and data.
 */
class ResultViewModel(
    correctAnswers: Int,
    totalQuestions: Int,
    difficulty: String
) : ViewModel() {

    private val _correctAnswers = MutableLiveData<Int>(correctAnswers)
    val correctAnswers = _correctAnswers

    private val _totalQuestions = MutableLiveData<Int>(totalQuestions)
    val totalQuestions = _totalQuestions

    private val _difficulty = MutableLiveData<String>(difficulty)
    val difficulty = _difficulty

    private val _scoreText = MutableLiveData<String>("$correctAnswers/$totalQuestions")
    val scoreText = _scoreText

    private val _resultTitle = MutableLiveData<String>("Resultado - Nivel $difficulty")
    val resultTitle = _resultTitle

}