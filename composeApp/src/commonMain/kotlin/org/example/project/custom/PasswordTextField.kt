package org.eran.project.custom

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import rickmortyapp.composeapp.generated.resources.Res
import rickmortyapp.composeapp.generated.resources.closed_eye
import rickmortyapp.composeapp.generated.resources.eye
import rickmortyapp.composeapp.generated.resources.lock
import org.eran.project.bgGreen
import org.jetbrains.compose.resources.painterResource

@Composable
fun PasswordTextField(
    password: String, onValueChange: (String) -> Unit
) {

    var passwordVisible by remember { mutableStateOf(false) }

    RoundedTextField(
        value = password,
        onValueChange = onValueChange,
        label = { Text("Password") },
        leadingIcon = Res.drawable.lock,
        iconModifier = Modifier.size(24.dp),
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    painter = painterResource(if (passwordVisible) Res.drawable.eye else Res.drawable.closed_eye),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = bgGreen
                )
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
    )
}