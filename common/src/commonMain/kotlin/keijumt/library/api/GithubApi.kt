package keijumt.library.api

import keijumt.library.model.User

internal interface GithubApi {
    suspend fun getUser(userId: String): User
}

internal class GithubApiImpl(private val apiClient: ApiClient) : GithubApi {
    override suspend fun getUser(userId: String): User = apiClient.get("users/$userId")
}
