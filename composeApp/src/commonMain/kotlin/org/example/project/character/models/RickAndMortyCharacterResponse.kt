package org.example.project.character.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RickAndMortyCharacterResponse(
    @SerialName("info")
    val info: Info,
    @SerialName("results")
    val characters: List<Character>
)