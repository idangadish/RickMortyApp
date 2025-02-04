package org.example.project.di

import io.ktor.client.engine.HttpClientEngine
import okhttp3.OkHttp
import org.example.project.core.data.HttpClientFactory
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single<HttpClientEngine> { io.ktor.client.engine.okhttp.OkHttp.create() }

    }