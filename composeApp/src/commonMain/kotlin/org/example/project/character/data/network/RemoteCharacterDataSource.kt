package org.example.project.character.data.network

import org.example.project.character.data.models.RickAndMortyCharacterResponse
import org.example.project.core.domain.DataError
import org.example.project.core.domain.Result

interface RemoteCharacterDataSource {
    suspend fun searchCharacters(
        query: String,
        resultLimit: Int? = null
    ): Result<RickAndMortyCharacterResponse, DataError.Remote>
}