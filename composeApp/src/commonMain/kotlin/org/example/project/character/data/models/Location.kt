package org.example.project.character.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    @SerialName("name")
    val name: String? = null,
    @SerialName("url")
    val url: String? = null
)