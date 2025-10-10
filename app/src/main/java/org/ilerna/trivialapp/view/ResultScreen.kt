package org.ilerna.trivialapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.ilerna.trivialapp.R

@Composable
fun ResultScreen(
    correctAnswers: Int,
    totalQuestions: Int,
    difficulty: String,
    onShare: () -> Unit,
    onBackToMenu: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically)
    ) {
        // App icon
        Image(
            painter = painterResource(id = R.drawable.ic_planet),
            contentDescription = "Universe Trivia Icon",
            modifier = Modifier.size(80.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Result title
        Text(
            text = "Resultado - Nivel $difficulty",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        )

        // Score
        Text(
            text = "$correctAnswers/$totalQuestions",
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Share button
        Button(
            onClick = onShare
        ) {
            Text(
                text = "Compartir",
                style = MaterialTheme.typography.titleMedium
            )
        }

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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ResultScreenPreview() {
    MaterialTheme {
        ResultScreen(
            correctAnswers = 7,
            totalQuestions = 10,
            difficulty = "Easy",
            onShare = { },
            onBackToMenu = { }
        )
    }
}