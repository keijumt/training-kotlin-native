package keijumt.training_kotlin_native

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import keijumt.api.GithubApi
import keijumt.model.User
import keijumt.presentation.presenter.GithubPresenterImpl
import keijumt.presentation.view.GithubView
import keijumt.repository.GithubRepositoryImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity(), GithubView {

    private val presenter by lazy { GithubPresenterImpl(Dispatchers.Main, this, GithubRepositoryImpl(GithubApi())) }

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
