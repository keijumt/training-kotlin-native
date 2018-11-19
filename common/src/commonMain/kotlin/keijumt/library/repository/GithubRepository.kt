package keijumt.library.repository

import keijumt.library.api.GithubApi
import keijumt.library.model.User

internal interface GithubRepository {
    suspend fun getUser(userId: String): User
}

internal class GithubRepositoryImpl(private val githubApi: GithubApi) : GithubRepository {
    override suspend fun getUser(userId: String): User = githubApi.getUser(userId)
}
