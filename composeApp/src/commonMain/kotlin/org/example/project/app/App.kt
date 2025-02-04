package org.example.project.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.ktor.client.engine.HttpClientEngine
import org.example.project.character.presentation.characters_list.CharacterListScreenRoot
import org.example.project.character.presentation.characters_list.CharactersViewModel
import org.example.project.character.presentation.deatiled_character.CharacterScreen
import org.example.project.character.presentation.log_in.LoginActionListener
import org.example.project.character.presentation.log_in.LoginScreen
import org.example.project.character.presentation.log_in.LoginViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel


@Composable
@Preview
fun App(engine: HttpClientEngine) {
    MaterialTheme {
        val navController = rememberNavController()
        val charactersViewModel = koinViewModel<CharactersViewModel>()

        NavHost(
            navController = navController,
            startDestination = Routes.LogIn.route
        ) {
            composable(Routes.LogIn.route) {
                val viewModel = remember { LoginViewModel() }
                LoginScreen(
                    viewModel = viewModel,
                    listener = object : LoginActionListener {
                        override fun onLoginSuccess() {
                            navController.navigate(Routes.CharacterList.route)
                        }
                    }
                )
            }


            composable(Routes.CharacterList.route) {
                CharacterListScreenRoot(
                    viewModel = charactersViewModel,
                    onCharacterClick = { character ->
                        val detailsRoute = Routes.CharacterDetail.route
                        charactersViewModel.setCharacter(character)
                        navController.navigate(detailsRoute)
                    }
                )
            }

            composable(Routes.CharacterDetail.route) {
                CharacterScreen(charactersViewModel){
                    navController.navigateUp()
                }
            }
        }
    }
}
