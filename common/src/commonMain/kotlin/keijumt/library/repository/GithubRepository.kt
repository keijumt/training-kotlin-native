package keijumt.library.repository

import keijumt.library.api.GithubApi
import keijumt.library.model.User

interface GithubRepository {
    suspend fun getUser(userId: String): User
}

class GithubRepositoryImpl(private val githubApi: GithubApi) : GithubRepository {
    override suspend fun getUser(userId: String): User {
        return githubApi.getUser(userId)
    }
}