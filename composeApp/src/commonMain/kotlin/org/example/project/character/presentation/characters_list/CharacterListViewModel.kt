package org.example.project.character.presentation.characters_list

import androidx.lifecycle.ViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CharacterListViewModel: ViewModel() {

    private val _state = MutableStateFlow(CharactersListState())
    val state = _state.asStateFlow()

    fun onAction(action: CharactersListAction){
        when(action){
            is CharactersListAction.OnCharacterClick -> {
                //_state.update {
                //    it.copy(searchQuery = action.query)
                //}
            }
            is CharactersListAction.OnSearchQueryChange -> {
                _state.update {
                    it.copy(searchQuery = action.query)
                }

            }
        }
    }
}