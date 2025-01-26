package org.example.project

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import io.ktor.client.engine.darwin.Darwin
import org.example.project.app.App
import org.example.project.di.initKoin

fun MainViewController() = ComposeUIViewController {

    App(
        engine = remember {
            Darwin.create {
                initKoin()
            }
        }
    )
}