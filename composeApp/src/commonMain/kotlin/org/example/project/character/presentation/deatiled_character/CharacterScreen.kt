package org.example.project.character.presentation.deatiled_character

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.example.project.character.domain.Character
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CharacterScreen(character: Character) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFD9F1E7) // Soft pastel green background
    ) {
        Column {
            // Green Header Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF53D1A6)) // Light green header
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Character",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White // White text
                )
            }

            // White Card for Character Content
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.8f) // Adjust the width of the card
                        .padding(top = 16.dp)
                        .wrapContentHeight(), // Height wraps the content
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Character Image
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.size(150.dp)
                        ) {
                            AsyncImage(
                                model = character.imageUrl,
                                contentDescription = "Character Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Spacer(Modifier.height(8.dp))
                        Text(character.name)
                        Text(character.status + " - "+ character.species)
                        Text(character.originName)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewCharScreen() {
    val character = Character(
        id = 288,
        name = "Rick D716-B",
        status = "Alive",
        species = "Human",
        type = "",
        gender = "Male",
        originName = "Earth (D716-B)",
        currentLocation = "Citadel of Ricks",
        imageUrl = "https://rickandmortyapi.com/api/character/avatar/288.jpeg",
        creationDate = "2017-12-31T19:55:25.101Z"
    )
    CharacterScreen(character = character)
}

