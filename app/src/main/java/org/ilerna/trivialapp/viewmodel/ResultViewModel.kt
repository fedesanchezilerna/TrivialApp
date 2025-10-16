package org.ilerna.trivialapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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
    
    private val _scorePercentage = MutableLiveData<Float>(
        (correctAnswers.toFloat() / totalQuestions.toFloat()) * 100
    )
    val scorePercentage = _scorePercentage
    
    private val _scoreText = MutableLiveData<String>("$correctAnswers/$totalQuestions")
    val scoreText = _scoreText
    
    private val _resultTitle = MutableLiveData<String>("Resultado - Nivel $difficulty")
    val resultTitle = _resultTitle
    
    fun getShareText(): String {
        val percentage = _scorePercentage.value ?: 0f
        return "Nivel: ${_difficulty.value}\n" +
                "Puntuación: ${_correctAnswers.value}/${_totalQuestions.value} (${percentage.toInt()}%)"
    }
    
}