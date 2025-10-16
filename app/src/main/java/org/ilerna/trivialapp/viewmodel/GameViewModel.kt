package org.ilerna.trivialapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.ilerna.trivialapp.model.Question
import org.ilerna.trivialapp.model.QuestionProvider

class GameViewModel(
    private val difficulty: String
) : ViewModel() {
    
    private val questions = when (difficulty) {
        "Easy" -> QuestionProvider.getQuestionsByDifficultyRandomized("Easy").take(10)
        "Medium" -> QuestionProvider.getQuestionsByDifficultyRandomized("Medium").take(10)
        "Hard" -> QuestionProvider.getQuestionsByDifficultyRandomized("Hard").take(10)
        "Random" -> QuestionProvider.getRandomQuestions(10)
        "ALL" -> QuestionProvider.getAllQuestions().shuffled().take(30)
        else -> QuestionProvider.getQuestionsByDifficultyRandomized("Easy").take(10)
    }
    
    private val _currentQuestionIndex = MutableLiveData<Int>(0)
    val currentQuestionIndex = _currentQuestionIndex
    
    private val _correctAnswers = MutableLiveData<Int>(0)
    val correctAnswers = _correctAnswers
    
    private val _currentQuestion = MutableLiveData<Question>(questions.first())
    val currentQuestion = _currentQuestion
    
    private val _gameFinished = MutableLiveData<Boolean>(false)
    val gameFinished = _gameFinished
    
    private val _progress = MutableLiveData<Float>(1f / questions.size.toFloat())
    val progress = _progress
    
    private val _currentRound = MutableLiveData<Int>(1)
    val currentRound = _currentRound
    
    val totalQuestions = questions.size
    
    init {
        updateCurrentQuestion()
    }
    
    private fun updateCurrentQuestion() {
        val index = _currentQuestionIndex.value ?: 0
        if (index < questions.size) {
            _currentQuestion.value = questions[index]
            _currentRound.value = index + 1
            _progress.value = (index + 1).toFloat() / totalQuestions.toFloat()
        }
    }
    
    fun handleAnswerSelected(answerIndex: Int) {
        val currentIndex = _currentQuestionIndex.value ?: 0
        val currentQ = questions[currentIndex]
        
        // Check if answer is correct
        if (answerIndex == currentQ.correctAnswerIndex) {
            _correctAnswers.value = (_correctAnswers.value ?: 0) + 1
        }
        
        // Move to next question or finish game
        if (currentIndex < totalQuestions - 1) {
            _currentQuestionIndex.value = currentIndex + 1
            updateCurrentQuestion()
        } else {
            // Game finished
            _gameFinished.value = true
        }
    }
    
    fun getCorrectAnswersCount(): Int {
        return _correctAnswers.value ?: 0
    }
    
    fun getTotalQuestionsCount(): Int {
        return totalQuestions
    }
    
    fun getDifficulty(): String {
        return difficulty
    }
}