package org.example.project.character.presentation.characters_list

import org.example.project.character.domain.Character
import org.example.project.core.presentation.UiText

data class CharactersListState(
    val searchQuery: String = "",
    val searchResults: List<Character> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: UiText? = null
)
