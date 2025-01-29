package org.example.project.character.presentation.deatiled_character

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.example.project.character.domain.Character

class DetailedCharacterViewModel: ViewModel() {

    private val _detailedCharacter = MutableStateFlow<Character?>(null)
    val detailedCharacter = _detailedCharacter.asStateFlow()

    fun onDetailedCharacter(character: Character){
        _detailedCharacter.value = character
    }

}