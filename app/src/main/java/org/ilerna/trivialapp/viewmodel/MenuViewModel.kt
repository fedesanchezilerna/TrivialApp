package org.ilerna.trivialapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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
    
    fun setSelectedDifficulty(difficulty: String) {
        _selectedDifficulty.value = difficulty
        _isGameStartEnabled.value = difficulty.isNotBlank()
    }
    
    fun setDropdownExpanded(expanded: Boolean) {
        _dropdownExpanded.value = expanded
    }
    
    fun onDifficultySelected(difficulty: String) {
        setSelectedDifficulty(difficulty)
        setDropdownExpanded(false)
    }
}