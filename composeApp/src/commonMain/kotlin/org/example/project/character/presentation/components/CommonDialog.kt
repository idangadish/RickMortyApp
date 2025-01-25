package org.example.project.character.presentation.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun CommonDialog(title: String, text: String) {
   var isDialogOpen by remember { mutableStateOf(false) }

   if (isDialogOpen) {
       AlertDialog(
           onDismissRequest = { },
           confirmButton = {
               Button(onClick = { isDialogOpen = false }) {
                   Text("OK")
               }
           },
           title = { Text(title) },
           text = { Text(text) },
       )
   }
}