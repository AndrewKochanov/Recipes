package com.example.recipes.data.network

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*

class KtorClientFactory() {

    fun build(): HttpClient {
        return HttpClient(CIO) {
            install(ContentNegotiation) {
                json()
            }
        }
    }
}