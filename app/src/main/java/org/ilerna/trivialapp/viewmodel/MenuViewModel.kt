package org.ilerna.trivialapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ViewModel for the menu screen.
 * Handles the menu logic and data.
 */
class MenuViewModel : ViewModel() {
    
    private val difficultyOptions = listOf(
        "Easy",
        "Medium", 
        "Hard",
        "Random",
        "ALL"
    )
    
    private val _selectedDifficulty = MutableLiveData<String>("")
    val selectedDifficulty = _selectedDifficulty
    
    private val _dropdownExpanded = MutableLiveData<Boolean>(false)
    val dropdownExpanded = _dropdownExpanded
    
    private val _isGameStartEnabled = MutableLiveData<Boolean>(false)
    val isGameStartEnabled = _isGameStartEnabled
    
    fun getDifficultyOptions(): List<String> {
        return difficultyOptions
    }
    
    /**
     * Set the selected difficulty.
     * Update the isGameStartEnabled flag to true if the difficulty is not blank.
     */
    fun setSelectedDifficulty(difficulty: String) {
        _selectedDifficulty.value = difficulty
        _isGameStartEnabled.value = difficulty.isNotBlank()
    }
    
    /**
     * Set the dropdown expanded state.
     */
    fun setDropdownExpanded(expanded: Boolean) {
        _dropdownExpanded.value = expanded
    }
    
    /**
     * Handle the difficulty selected by the user.
     * Set the selected difficulty and close the dropdown.
     */
    fun onDifficultySelected(difficulty: String) {
        setSelectedDifficulty(difficulty)
        setDropdownExpanded(false)
    }
}