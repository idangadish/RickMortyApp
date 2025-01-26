package org.example.project.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.ktor.client.engine.HttpClientEngine
import org.example.project.character.domain.CharacterRepository
import org.example.project.character.presentation.characters_list.CharacterListViewModel
import org.example.project.character.presentation.log_in.LoginActionListener
import org.example.project.character.presentation.log_in.LoginScreen
import org.example.project.character.presentation.log_in.LoginViewModel

import org.jetbrains.compose.ui.tooling.preview.Preview



@Composable
@Preview
fun App(engine: HttpClientEngine) {
    MaterialTheme {
        val navController = rememberNavController()

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
                // Implement CharacterList screen
            }
        }
    }
}
          //  composable(Routes.CharacterList.route) {
          //      val viewModel = remember { CharacterListViewModel() }
          //      CharacterListScreen(
          //          viewModel = viewModel,
          //          onCharacterClick = { character ->
          //              navController.navigate(Routes.CharacterDetail(character.id).route)
          //          }
          //      )
          //  }
//
          //  composable(
          //      route = Routes.CharacterDetail.route ,
          //      arguments = listOf(
          //          navArgument("id") { type = NavType.StringType }
          //      )
          //  ) { backStackEntry ->
          //      val characterId = backStackEntry.arguments?.getString("id")
          //      val viewModel = remember { CharacterDetailViewModel(characterId) }
          //      CharacterDetailScreen(
          //          viewModel = viewModel,
          //          onBackClick = { navController.navigateUp() }
          //      )
          //  }


//fun App() {
//    LoginScreen(viewModel = remember { LoginViewModel() }, listener = object : LoginActionListener {
//        override fun onLoginSuccess() {
//            TODO("Move to CharacterListScreenRoot")
//        }
//    })
