package org.example.project

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.example.project.character.presentation.log_in.LoginActionListener
import org.example.project.character.presentation.log_in.LoginScreen
import org.example.project.character.presentation.log_in.LoginViewModel

import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    LoginScreen(viewModel = remember { LoginViewModel() }, listener = object : LoginActionListener {
        override fun onLoginSuccess() {
            TODO("Move to CharacterListScreenRoot")
        }
    })
//    CharchterListScreenRoot(
//        viewModel = remember { CharacterListViewModel() },
//        onCharacterClick = {
//
//        }
//
//    )
}