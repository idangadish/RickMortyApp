package org.example.project.character.presentation.characters_list

import org.example.project.character.domain.Character

sealed interface CharactersListAction {
    data class OnSearchQueryChange(val query: String): CharactersListAction
    data class OnCharacterClick(val character: Character): CharactersListAction
}