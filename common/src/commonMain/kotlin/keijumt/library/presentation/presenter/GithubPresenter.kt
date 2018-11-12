package keijumt.library.presentation.presenter

import keijumt.library.presentation.view.GithubView
import keijumt.library.repository.GithubRepository
import kotlinx.coroutines.launch

interface GithubPresenter {
    fun fetchUser(userId: String)
}

class GithubPresenterImpl(
        private val view: GithubView,
        private val githubRepository: GithubRepository
) : CoroutinePresenter(), GithubPresenter {

    override fun fetchUser(userId: String) {
        launch {
            view.showUser(githubRepository.getUser("keijumt"))
        }
    }
}