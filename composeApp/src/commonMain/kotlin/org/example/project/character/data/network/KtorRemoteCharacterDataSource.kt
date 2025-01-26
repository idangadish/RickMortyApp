package org.example.project.character.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.example.project.character.data.models.RickAndMortyCharacterResponse
import org.example.project.core.data.safeCall
import org.example.project.core.domain.DataError
import org.example.project.core.domain.Result

private val BASE_URL = "https://rickandmortyapi.com/api/"

class KtorRemoteCharacterDataSource(private val httpClient: HttpClient) : RemoteCharacterDataSource {
    override suspend fun searchCharacters(
        query: String,
        resultLimit: Int?
    ): Result<RickAndMortyCharacterResponse, DataError.Remote> {
        return safeCall {
            httpClient.get(
                urlString = "$BASE_URL/character"
            ) {
                if (query.isNotBlank()) {
                    parameter("name", query) // השתמש ב-"name" כדי לסנן לפי שם
                }
                resultLimit?.let { parameter("limit", it) }
                parameter("language", "eng")

            }
        }


    }
}