package org.example.project.character.presentation.characters_list.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.ScrollScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.character.domain.Character
import org.example.project.character.presentation.characters_list.CharactersListAction

@Composable
fun CharacterList(
    characters: List<Character>,
    onCharacterClick: (Character) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // 2 items per row
        modifier = modifier,
        contentPadding = PaddingValues(16.dp), // Padding around the grid
        horizontalArrangement = Arrangement.spacedBy(16.dp), // Space between items horizontally
        verticalArrangement = Arrangement.spacedBy(12.dp) // Space between rows vertically
    ) {
        items(characters, key = { it.id }) { character ->
            CharacterListItem(
                character = character,
                modifier = Modifier
                    .padding(8.dp), // Optional padding for individual items
                onClick = {
                    onCharacterClick(character)
                }
            )
        }
    }
}


