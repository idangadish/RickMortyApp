package org.example.project.character.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterModel(
    @SerialName("id")
    val id: Int,
    @SerialName("created")
    val created: String? = null,
    @SerialName("episode")
    val episode: List<String>? = null,
    @SerialName("gender")
    val gender: String? = null,
    @SerialName("image")
    val image: String? = null,
    @SerialName("location")
    val location: Location? = null,
    @SerialName("name")
    val name: String,
    @SerialName("origin")
    val origin: Origin? = null,
    @SerialName("species")
    val species: String? = null,
    @SerialName("status")
    val status: String? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("url")
    val url: String? = null
)