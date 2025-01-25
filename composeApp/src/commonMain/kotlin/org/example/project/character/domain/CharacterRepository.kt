package org.example.project.character.domain

import org.example.project.core.domain.DataError
import org.example.project.core.domain.Result

interface CharacterRepository {
    suspend fun searchCharacters(query: String): Result<List<Character>, DataError.Remote>
}