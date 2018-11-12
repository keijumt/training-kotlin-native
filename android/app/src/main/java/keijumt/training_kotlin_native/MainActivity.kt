package keijumt.training_kotlin_native

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import keijumt.library.api.GithubApi
import keijumt.library.model.User
import keijumt.library.presentation.presenter.GithubPresenterImpl
import keijumt.library.presentation.view.GithubView
import keijumt.library.repository.GithubRepositoryImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GithubView {

    private val presenter by lazy { GithubPresenterImpl(this, GithubRepositoryImpl(GithubApi())) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.fetchUser("keijumt")
    }

    override fun showUser(user: User) {
        progress_bar.visibility = View.GONE
        text_sample.text = user.name
    }
}
