package keijumt.presentation.presenter

import keijumt.presentation.view.GithubView
import keijumt.repository.GithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

interface GithubPresenter {
    fun fetchUser(userId: String)
}

class GithubPresenterImpl(
        context: CoroutineContext,
        private val view: GithubView,
        private val githubRepository: GithubRepository
) : CoroutinePresenter(context), GithubPresenter {

    override fun fetchUser(userId: String) {
        launch(Dispatchers.Main) {

        }
        launch {
            view.showUser(githubRepository.getUser("keijumt"))
        }
    }
}