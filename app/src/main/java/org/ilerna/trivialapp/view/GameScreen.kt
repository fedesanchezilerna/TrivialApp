package org.ilerna.trivialapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.ilerna.trivialapp.R
import org.ilerna.trivialapp.model.QuestionProvider

@Composable
fun GameScreen(
    difficulty: String,
    onGameFinished: (Int, Int) -> Unit, // (correctAnswers, totalQuestions)
    onBackToMenu: () -> Unit // Navigation back to menu
) {
    // Get questions based on difficulty
    val questions = remember {
        when (difficulty) {
            "Easy" -> QuestionProvider.getQuestionsByDifficultyRandomized("Easy").take(10)
            "Medium" -> QuestionProvider.getQuestionsByDifficultyRandomized("Medium").take(10)
            "Hard" -> QuestionProvider.getQuestionsByDifficultyRandomized("Hard").take(10)
            "Random" -> QuestionProvider.getRandomQuestions(10)
            "ALL" -> QuestionProvider.getAllQuestions().shuffled().take(30)
            else -> QuestionProvider.getQuestionsByDifficultyRandomized("Easy").take(10)
        }
    }

    var currentQuestionIndex by remember { mutableIntStateOf(0) }
    var correctAnswers by remember { mutableIntStateOf(0) }
    var selectedAnswer by remember { mutableIntStateOf(-1) }
    var showResult by remember { mutableStateOf(false) }

    val currentQuestion = questions[currentQuestionIndex]
    val totalQuestions = questions.size
    val currentRound = currentQuestionIndex + 1
    val progress = currentRound.toFloat() / totalQuestions.toFloat()

    // Handle answer selection and navigation
    fun handleAnswerSelected(answerIndex: Int) {
        selectedAnswer = answerIndex

        // Check if answer is correct
        if (answerIndex == currentQuestion.correctAnswerIndex) {
            correctAnswers++
        }

        // Move to next question or finish game
        if (currentQuestionIndex < totalQuestions - 1) {
            currentQuestionIndex++
            selectedAnswer = -1
        } else {
            // Game finished
            onGameFinished(correctAnswers, totalQuestions)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // App icon
        Image(
            painter = painterResource(id = R.drawable.ic_planet),
            contentDescription = "Universe Trivia Icon",
            modifier = Modifier.size(60.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Question text
        Text(
            text = currentQuestion.questionText,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        // Difficulty level
        Text(
            text = "Nivel: ${currentQuestion.difficulty}",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.secondary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Answer options in 2x2 grid
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // First row (options 0 and 1)
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                AnswerButton(
                    text = currentQuestion.options[0],
                    onClick = { handleAnswerSelected(0) },
                    modifier = Modifier.weight(1f)
                )
                AnswerButton(
                    text = currentQuestion.options[1],
                    onClick = { handleAnswerSelected(1) },
                    modifier = Modifier.weight(1f)
                )
            }

            // Second row (options 2 and 3)
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                AnswerButton(
                    text = currentQuestion.options[2],
                    onClick = { handleAnswerSelected(2) },
                    modifier = Modifier.weight(1f)
                )
                AnswerButton(
                    text = currentQuestion.options[3],
                    onClick = { handleAnswerSelected(3) },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Progress bar
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Progreso",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "$currentRound de $totalQuestions",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Back to Menu button
        Button(
            onClick = onBackToMenu
        ) {
            Text(
                text = "Volver al Menú",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun AnswerButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(80.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GameScreenPreview() {
    MaterialTheme {
        GameScreen(
            difficulty = "Easy",
            onGameFinished = { _, _ -> },
            onBackToMenu = { }
        )
    }
}