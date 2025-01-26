package org.example.project.di

import org.example.project.character.data.network.KtorRemoteCharacterDataSource
import org.example.project.character.data.network.RemoteCharacterDataSource
import org.example.project.character.data.repository.DefaultCharacterRepository
import org.example.project.character.domain.CharacterRepository
import org.example.project.character.presentation.characters_list.CharacterListViewModel
import org.example.project.core.data.HttpClientFactory
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module


expect val platformModule:Module

val sharedModule= module {

    single { HttpClientFactory.createHttpClient(get()) }
    singleOf (::KtorRemoteCharacterDataSource).bind <RemoteCharacterDataSource>()

    // Provide CharacterRepository implementation
    single<CharacterRepository> { DefaultCharacterRepository(get()) }

    // Provide ViewModel
    viewModel { CharacterListViewModel(get()) }
}
