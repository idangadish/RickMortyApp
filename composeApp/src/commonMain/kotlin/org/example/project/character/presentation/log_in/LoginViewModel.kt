package org.example.project.character.presentation.log_in

import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() {

    fun login(email: String, password: String) =
        email == "abc@ddd.eee" && password == "1234"

}