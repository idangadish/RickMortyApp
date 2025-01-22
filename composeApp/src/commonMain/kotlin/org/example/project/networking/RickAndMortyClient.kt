package org.example.project.networking

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import org.example.project.character.models.Character
import org.example.project.character.models.RickAndMortyCharacterResponse
import org.example.project.core.NetworkError
import org.example.project.core.domain.Result

class RickAndMortyClient(
    private val httpClient: HttpClient
) {
    private val baseURL = "https://rickandmortyapi.com/api/"

    suspend fun getCharacters(): Result<RickAndMortyCharacterResponse, NetworkError> {
        val response =
            try {
                httpClient.get(baseURL + "character") {
                }
            } catch (e: UnresolvedAddressException) {
                return Result.Error(NetworkError.NO_INTERNET)
            } catch (e: SerializationException) {
                return Result.Error(NetworkError.SERIALIZATION)
            }
        return when (response.status.value) {
            in 200..299 -> {
                val response = response.body<RickAndMortyCharacterResponse>()
                Result.Success(response)
            }
            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            409 -> Result.Error(NetworkError.CONFLICT)
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            413 -> Result.Error(NetworkError.PAYLOAD_TOO_LARGE)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }

    suspend fun getCharacterByID(id:Int): Result<Character, NetworkError> {
        val response =
            try {
                httpClient.get("${baseURL}character/$id") {

                }
            } catch (e: UnresolvedAddressException) {
                return Result.Error(NetworkError.NO_INTERNET)
            } catch (e: SerializationException) {
                return Result.Error(NetworkError.SERIALIZATION)
            }
        return when (response.status.value) {
            in 200..299 -> {
                val response = response.body<Character>()
                Result.Success(response)
            }
            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            409 -> Result.Error(NetworkError.CONFLICT)
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            413 -> Result.Error(NetworkError.PAYLOAD_TOO_LARGE)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }
}