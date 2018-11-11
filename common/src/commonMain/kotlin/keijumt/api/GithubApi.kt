package keijumt.api

import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.url
import keijumt.model.User

class GithubApi : Api() {

    override val baseUrl: String
        get() = "https://api.github.com"

    suspend fun getUser(userId: String): User = client.get(path = "users/$userId") {
        url(baseUrl)
    }

    override fun getSerializer() = KotlinxSerializer().apply {
        setMapper(User::class, User.serializer())
    }
}