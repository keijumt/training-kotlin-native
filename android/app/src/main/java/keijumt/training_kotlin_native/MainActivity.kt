package keijumt.training_kotlin_native

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import keijumt.createApplicationScreenMessage
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_sample.text = createApplicationScreenMessage()
    }
}
