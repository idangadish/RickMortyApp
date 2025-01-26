package org.example.project.character.presentation.log_in

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.eran.project.bgGreen
import org.example.project.custom.EmailTextField
import org.example.project.custom.PasswordTextField
import org.example.project.character.presentation.components.SharedScaffold
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import rickmortyapp.composeapp.generated.resources.Res
import rickmortyapp.composeapp.generated.resources.rickLogo



@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel(),
    listener: LoginActionListener
) {
    // State variables for email, password, and password visibility
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    SharedScaffold(
        title = "Login"
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Top section with logo and input fields
            Icon(
                painter = painterResource(Res.drawable.rickLogo),
                contentDescription = null,
                modifier = Modifier.size(110.dp),
                tint = Color.Unspecified
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Email field
            EmailTextField(email) {
                email = it
                error = ""
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Password field
            PasswordTextField(password) {
                password = it
                error = ""
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(error, color = Color.Red, fontSize = 20.sp)

            Spacer(modifier = Modifier.height(32.dp))

            // Add weight to push the login button to the bottom
            Spacer(modifier = Modifier.weight(1f))

            // Login button
            Button(
                //Check only transfer to CharacterScreen without logic
                onClick = {
                    if (viewModel.login(email, password)) {
                        error = ""
                        listener.onLoginSuccess()
                    }
                    else {
                        listener.onLoginSuccess()  //Need for check
                        error = "Wrong credentials"

                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(bgGreen)
            ) {
                Text(text = "Login", fontSize = 22.sp, color = Color.White)
            }
        }
    }
}


