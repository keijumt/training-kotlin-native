package keijumt.library.di

import io.ktor.client.features.json.serializer.KotlinxSerializer
import keijumt.library.api.ApiClient
import keijumt.library.api.GithubApi
import keijumt.library.api.GithubApiImpl
import keijumt.library.model.User
import keijumt.library.repository.GithubRepository
import keijumt.library.repository.GithubRepositoryImpl

internal class Dependency {
    fun injectGithubRepository(): GithubRepository = GithubRepositoryImpl(injectGithubApi())
    fun injectGithubApi(): GithubApi = GithubApiImpl(ApiClient(
            baseUrl = "https://api.github.com",
            serializer = KotlinxSerializer().apply {
                setMapper(User::class, User.serializer())
            }
    ))
}
