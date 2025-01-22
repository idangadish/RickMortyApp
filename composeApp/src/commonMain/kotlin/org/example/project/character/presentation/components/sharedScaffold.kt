package org.example.project.character.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.eran.project.bgGreen
import org.eran.project.lightGreen

@Composable
fun SharedScaffold(
    title: String,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(title, color = Color.White, fontSize = 38.sp)
                    }
                },
                backgroundColor = bgGreen
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(lightGreen)
                    .padding(top = 50.dp)
            ) {
                content()
            }
        }
    )
}
