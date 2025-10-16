package org.ilerna.trivialapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.ilerna.trivialapp.R
import org.ilerna.trivialapp.viewmodel.MenuViewModel

@Composable
fun MenuScreen(navigateToGame: (String) -> Unit) {
    val menuViewModel: MenuViewModel = viewModel()
    
    val selectedDifficulty: String by menuViewModel.selectedDifficulty.observeAsState("")
    val dropdownExpanded: Boolean by menuViewModel.dropdownExpanded.observeAsState(false)
    val isGameStartEnabled: Boolean by menuViewModel.isGameStartEnabled.observeAsState(false)
    
    val difficultyOptions = menuViewModel.getDifficultyOptions()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        // Title
        Text(
            text = "Universe Trivia",
            style = TextStyle(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 36.sp
            ),
            textAlign = TextAlign.Center
        )

        // Planet Icon
        Image(
            painter = painterResource(id = R.drawable.ic_planet),
            contentDescription = "Planet Icon",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Difficulty Selection
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Select Difficulty:",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )

            // Dropdown
            Column {
                TextField(
                    value = selectedDifficulty,
                    onValueChange = { },
                    enabled = false,
                    readOnly = true,
                    label = { Text("Difficulty Level") },
                    modifier = Modifier.clickable { 
                        menuViewModel.setDropdownExpanded(true) 
                    }
                )
                DropdownMenu(
                    expanded = dropdownExpanded,
                    onDismissRequest = { menuViewModel.setDropdownExpanded(false) }
                ) {
                    difficultyOptions.forEach { difficulty ->
                        DropdownMenuItem(
                            text = { Text(difficulty) },
                            onClick = {
                                menuViewModel.onDifficultySelected(difficulty)
                            }
                        )
                    }
                }
            }

            // Start Game Button
            Button(
                onClick = { navigateToGame(selectedDifficulty) },
                enabled = isGameStartEnabled
            ) {
                Text(
                    text = "Start Game",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MenuScreenPreview() {
    MaterialTheme {
        MenuScreen(navigateToGame = {})
    }
}