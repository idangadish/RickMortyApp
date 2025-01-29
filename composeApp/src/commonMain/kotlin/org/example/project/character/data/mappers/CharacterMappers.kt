package org.example.project.character.data.mappers

import org.example.project.character.data.models.CharacterModel
import org.example.project.character.domain.Character


fun CharacterModel.toCharacter(): Character{
    return Character(
        id = id,
        name = name,
        imageUrl = image ?: "",
        creationDate = created ?: "",
        currentLocation = location?.name ?: "",
        gender = gender ?: "",
        originName = origin?.name ?: "",
        species = species ?: "",
        status = status ?: "",
        type = type ?: ""
    )
}