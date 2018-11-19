package keijumt.library.api

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url

internal class ApiClient(private val baseUrl: String, serializer: KotlinxSerializer) {
    private val client = HttpClient {
        install(JsonFeature) {
            this.serializer = serializer
        }
    }

    suspend inline fun <reified T> get(path: String, param: Map<String, String> = mapOf("k1" to "v1", "k2" to "v2")): T = client.get(path = path) {
        url(baseUrl)
        param.forEach {
            parameter(it.key, it.value)
        }
    }
}
