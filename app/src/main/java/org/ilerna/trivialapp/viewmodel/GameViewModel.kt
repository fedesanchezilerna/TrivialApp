package org.ilerna.trivialapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.ilerna.trivialapp.model.Question
import org.ilerna.trivialapp.model.QuestionProvider

/**
 * ViewModel for the game screen.
 * Handles the game logic and data.
 */
class GameViewModel(
    private val difficulty: String,
    private val onGameFinished: (Int, Int) -> Unit
) : ViewModel() {
    
    /**
     * Questions to be used in the game.
     * Depending on the difficulty, the questions are selected from the QuestionProvider.
     */
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

    private val _progress = MutableLiveData<Float>(1f / questions.size.toFloat())
    val progress = _progress
    
    private val _currentRound = MutableLiveData<Int>(1)
    val currentRound = _currentRound
    
    val totalQuestions = questions.size
    
    /**
     * Initialize the game by updating the current question.
     */
    init {
        updateCurrentQuestion()
    }
    
    /**
     * Update the current question by incrementing the index and updating the current question.
     */
    private fun updateCurrentQuestion() {
        val index = _currentQuestionIndex.value ?: 0
        if (index < questions.size) {
            _currentQuestion.value = questions[index]
            _currentRound.value = index + 1
            _progress.value = (index + 1).toFloat() / totalQuestions.toFloat()
        }
    }
    
    /**
     * Handle the answer selected by the user.
     * Check if the answer is correct and update the correct answers count.
     * Move to the next question or finish the game if the last question is reached.
     */
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
            onGameFinished(
                _correctAnswers.value ?: 0,
                totalQuestions
            )
        }
    }
    
    fun getDifficulty(): String {
        return difficulty
    }
}