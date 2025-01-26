package org.example.project

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import io.ktor.client.engine.HttpClientEngine
import org.example.project.character.data.network.KtorRemoteCharacterDataSource
import org.example.project.character.data.repository.DefaultCharacterRepository
import org.example.project.character.presentation.PreviewCharScreen
import org.example.project.character.presentation.characters_list.CharacterListViewModel
import org.example.project.character.presentation.characters_list.CharchterListScreenRoot
import org.example.project.character.presentation.log_in.LoginScreen
import org.example.project.core.data.HttpClientFactory

import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(engine: HttpClientEngine) {
    //    LoginScreen(viewModel = remember { LoginViewModel() }, listener = object : LoginActionListener {
//        override fun onLoginSuccess() {
//            TODO("Move to CharacterListScreenRoot")
//        }
//    })
    CharchterListScreenRoot(
        viewModel = remember {
            CharacterListViewModel(
                characterRepository = DefaultCharacterRepository(
                    remoteCharacterDataSource = KtorRemoteCharacterDataSource(
                        httpClient = HttpClientFactory.createHttpClient(
                            engine

                        )

                    )
                )
            )
        },
        onCharacterClick = {

        }

    )
}

