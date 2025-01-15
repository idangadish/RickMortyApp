package org.eran.project.custom

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun EmailTextField(email: String, onValueChange: (String) -> Unit) = RoundedTextField(
    value = email,
    onValueChange = onValueChange,
    label = { Text("Email") },
    leadingIcon = Icons.Default.Email,
    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
)