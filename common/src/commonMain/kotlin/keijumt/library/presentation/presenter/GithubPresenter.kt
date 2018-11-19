package keijumt.library.presentation.presenter

import keijumt.library.di.Dependency
import keijumt.library.presentation.view.GithubView
import keijumt.library.repository.GithubRepository
import kotlinx.coroutines.launch

interface GithubPresenter : Presenter {
    fun fetchUser(userId: String)
}

internal class GithubPresenterImpl(
        private val view: GithubView,
        dependency: Dependency = Dependency()
) : CoroutinePresenter(), GithubPresenter {
    private val githubRepository: GithubRepository = dependency.injectGithubRepository()

    override fun fetchUser(userId: String) {
        launch {
            try {
                val user = githubRepository.getUser("keijumt")
                view.showUser(user)
            } catch (t: Throwable) {
                view.showError(t.toString())
            }
        }
    }
}
