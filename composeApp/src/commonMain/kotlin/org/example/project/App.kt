package org.example.project

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.example.project.character.presentation.characters_list.CharacterListViewModel
import org.example.project.character.presentation.characters_list.CharchterListScreenRoot

import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    //LoginScreen()
    CharchterListScreenRoot(
        viewModel = remember { CharacterListViewModel() },
        onCharacterClick = {

        }

    )
}