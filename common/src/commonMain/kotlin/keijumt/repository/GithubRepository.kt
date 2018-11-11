package keijumt.repository

import keijumt.api.GithubApi
import keijumt.model.User

interface GithubRepository {
    suspend fun getUser(userId: String): User
}

class GithubRepositoryImpl(private val githubApi: GithubApi) : GithubRepository {
    override suspend fun getUser(userId: String): User {
        return githubApi.getUser(userId)
    }
}