package njc.koinprototype

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            setupFragment()
        }
    }

    private fun setupFragment() {
        val fragment = MainFragment.withArgs("parameter")
        supportFragmentManager.beginTransaction()
            .add(R.id.content, fragment)
            .commit()
    }
}
