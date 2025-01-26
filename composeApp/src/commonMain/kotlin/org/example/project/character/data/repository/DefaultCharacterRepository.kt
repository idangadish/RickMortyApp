package org.example.project.character.data.repository

import io.ktor.client.HttpClient
import org.example.project.character.data.mappers.toCharacter
import org.example.project.character.data.network.RemoteCharacterDataSource
import org.example.project.character.domain.Character
import org.example.project.character.domain.CharacterRepository
import org.example.project.core.domain.DataError
import org.example.project.core.domain.Result
import org.example.project.core.domain.map

class DefaultCharacterRepository (

    private val remoteCharacterDataSource: RemoteCharacterDataSource

):CharacterRepository {
    override suspend fun searchCharacters(query: String): Result<List<Character>, DataError.Remote> {
        return remoteCharacterDataSource.searchCharacters(query).map { dto -> dto.characters.map {it.toCharacter()} }
    }
}