package org.example.project.character.presentation.characters_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.character.domain.Character


@Composable
fun CharacterList(
    characters: List<Character>,
    onCharacterClick: (Character) -> Unit,
    modifier: Modifier = Modifier,
    scrollState: LazyGridState = rememberLazyGridState()
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // 2 items per row
        state = scrollState,
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


