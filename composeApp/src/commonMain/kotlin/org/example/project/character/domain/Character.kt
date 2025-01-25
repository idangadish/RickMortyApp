package org.example.project.character.domain

data class Character(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val status: String,
    val type:String,
    val species: String,
    val gender: String,
    val originName: String,
    val currentLocation: String,
    val creationDate: String
)
