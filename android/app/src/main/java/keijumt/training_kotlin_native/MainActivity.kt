package keijumt.training_kotlin_native

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import keijumt.library.model.User
import keijumt.library.presentation.view.GithubView
import kotlinx.android.synthetic.main.activity_main.*
import keijumt.library.PresenterFactory
import keijumt.library.presentation.presenter.GithubPresenter

class MainActivity : AppCompatActivity(), GithubView {
    private val presenter: GithubPresenter = PresenterFactory.getGithubPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.fetchUser("keijumt")
    }

    override fun showUser(user: User) {
        progress_bar.visibility = View.GONE
        text_sample.text = user.name
    }

    override fun showError(message: String) {
        progress_bar.visibility = View.GONE
        text_sample.text = message
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
