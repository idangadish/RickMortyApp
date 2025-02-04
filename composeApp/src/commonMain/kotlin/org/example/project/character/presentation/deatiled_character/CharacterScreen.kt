package org.example.project.character.presentation.deatiled_character


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.example.project.character.presentation.characters_list.CharactersViewModel


@Composable
fun CharacterScreen(
    charactersViewModel: CharactersViewModel,
    onBackClicked: () -> Unit // Lambda function for back navigation
) {
    val character = charactersViewModel.getCharacter()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFD9F1E7) // Soft pastel green background
    ) {
        Column {
            // Green Header Bar with Back Button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF53D1A6)) // Light green header
                    .padding(vertical = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Back Button
                    IconButton(onClick = { onBackClicked() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }

                    // Centered Title
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Character",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
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
                        .fillMaxWidth(0.8f)
                        .padding(top = 16.dp)
                        .wrapContentHeight(),
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

                        // Character Details
                        Text(character.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(
                            "${character.status} - ${character.species}",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                        Text(character.originName, fontSize = 14.sp, color = Color.DarkGray)
                    }
                }
            }
        }
    }
}


//@Preview
//@Composable
//fun PreviewCharScreen() {
//    val character = Character(
//        id = 288,
//        name = "Rick D716-B",
//        status = "Alive",
//        species = "Human",
//        type = "",
//        gender = "Male",
//        originName = "Earth (D716-B)",
//        currentLocation = "Citadel of Ricks",
//        imageUrl = "https://rickandmortyapi.com/api/character/avatar/288.jpeg",
//        creationDate = "2017-12-31T19:55:25.101Z"
//    )
//    CharacterScreen(charactersViewModel = character)
//}

