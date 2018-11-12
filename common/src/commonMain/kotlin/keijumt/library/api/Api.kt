package keijumt.library.api

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer

abstract class Api {

    protected abstract val baseUrl: String

    protected val client: HttpClient = HttpClient {
        install(JsonFeature) {
            serializer = getSerializer()
        }
    }

    init {
        client.config {

        }
    }

    abstract fun getSerializer(): KotlinxSerializer
}