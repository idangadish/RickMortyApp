package org.example.project.character.presentation.characters_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.character.domain.Character
import org.example.project.character.domain.CharacterRepository
import org.example.project.core.domain.onError
import org.example.project.core.domain.onSuccess
import org.example.project.core.presentation.toUiText

class CharacterListViewModel(private val characterRepository: CharacterRepository) : ViewModel() {

    private var cachedCharacters = emptyList<Character>()
    private var searchJob: Job? = null

    private val _state = MutableStateFlow(CharactersListState())
    val state = _state
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    init {
        // טען את כל הדמויות בתחילת הדרך
        loadAllCharacters()
        observeSearchQuery()
    }

    fun onAction(action: CharactersListAction) {
        when (action) {
            is CharactersListAction.OnCharacterClick -> {

            }

            is CharactersListAction.OnSearchQueryChange -> {
                _state.update {
                    it.copy(searchQuery = action.query)
                }
            }
        }
    }

    private fun observeSearchQuery() {
        state.map { it.searchQuery }
            .distinctUntilChanged()
            .debounce(500L)
            .onEach { query ->
                when {
                    query.isBlank() -> { // אם השאילתה ריקה, החזר את כל הדמויות
                        _state.update {
                            it.copy(
                                errorMessage = null,
                                searchResults = cachedCharacters
                            )
                        }
                    }

                    query.length >= 2 -> { // אם השאילתה מכילה טקסט, בצע חיפוש
                        searchJob?.cancel()
                        searchJob = searchCharacters(query)
                    }
                }
            }.launchIn(viewModelScope)
    }

    private fun loadAllCharacters() = viewModelScope.launch {
        _state.update {
            it.copy(isLoading = true)
        }

        characterRepository.searchCharacters("") // קריאה ריקה כדי לטעון את כל הדמויות
            .onSuccess { characters ->
                cachedCharacters = characters // שמור את הדמויות במשתנה cache
                _state.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = null,
                        searchResults = characters
                    )
                }
            }
            .onError { error ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = error.toUiText()
                    )
                }
            }
    }

    private fun searchCharacters(query: String) = viewModelScope.launch {
        _state.update {
            it.copy(isLoading = true)
        }

        characterRepository.searchCharacters(query)
            .onSuccess { searchResults ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = null,
                        searchResults = searchResults
                    )
                }
            }
            .onError { error ->
                _state.update {
                    it.copy(
                        searchResults = emptyList(),
                        isLoading = false,
                        errorMessage = error.toUiText()
                    )
                }
            }
    }
}
