package org.example.project.character.presentation.characters_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.eran.project.bgGreen
import org.eran.project.lightGreen
import org.example.project.character.domain.Character
import org.example.project.character.presentation.characters_list.components.CharacterList
import org.example.project.character.presentation.characters_list.components.CharacterSearchBar
import org.example.project.character.presentation.components.SharedScaffold
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import rickmortyapp.composeapp.generated.resources.Res
import rickmortyapp.composeapp.generated.resources.no_search_result

@Composable
fun CharchterListScreenRoot(
    viewModel: CharacterListViewModel = koinViewModel(),
    onCharacterClick: (Character) -> Unit,
    modifier: Modifier = Modifier
){
    val state by viewModel.state.collectAsStateWithLifecycle()

    CharactersScreen(state = state, onAction = { action->
        when(action){
            is CharactersListAction.OnCharacterClick -> onCharacterClick(action.character)
            else -> Unit
        }

        viewModel.onAction(action)

    })

}


@Composable
private fun CharactersScreen(
    state: CharactersListState,
    onAction: (CharactersListAction) -> Unit){

    val keyboardController = LocalSoftwareKeyboardController.current
    val searchResultState = rememberLazyGridState()

    LaunchedEffect(state.searchResults){
        searchResultState.animateScrollToItem(0)
    }

    SharedScaffold(
        title = "Characters"
    ){
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            CharacterSearchBar(
                searchQuery = state.searchQuery,
                onSearchQueryChange = {
                    onAction(CharactersListAction.OnSearchQueryChange(it))
                },
                onImeSearch = {
                    keyboardController?.hide()

                },
                modifier = Modifier.widthIn(max = 400.dp).fillMaxWidth().padding(16.dp)
            )



            Spacer(modifier = Modifier.height(4.dp))

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                if (state.isLoading) {
                    CircularProgressIndicator()
                } else {
                    when {
                        state.errorMessage != null -> {
                            Text(
                                text = state.errorMessage.asString(),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.headlineSmall,
                                color = MaterialTheme.colorScheme.error
                            )
                        }

                        state.searchResults.isEmpty() -> {
                            Text(
                                text = stringResource(Res.string.no_search_result),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.headlineSmall,
                                color = MaterialTheme.colorScheme.error
                            )
                        }


                        else -> {
                            CharacterList(
                                characters = state.searchResults,
                                onCharacterClick = {
                                    onAction(CharactersListAction.OnCharacterClick(it))
                                },
                                modifier = Modifier.fillMaxSize(),
                                scrollState = searchResultState

                            )
                        }
                    }
                }
            }


        }
    }
}


