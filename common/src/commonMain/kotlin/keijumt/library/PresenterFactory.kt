package keijumt.library

import keijumt.library.presentation.presenter.GithubPresenter
import keijumt.library.presentation.presenter.GithubPresenterImpl
import keijumt.library.presentation.view.GithubView

object PresenterFactory {
    fun getGithubPresenter(githubView: GithubView): GithubPresenter = GithubPresenterImpl(githubView)
}
