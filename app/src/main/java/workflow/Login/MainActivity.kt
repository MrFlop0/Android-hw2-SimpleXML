package workflow.Login

import android.content.res.Configuration.*
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<EditText>(R.id.Password).setOnEditorActionListener { _, id, _ ->
            when (id) {
                EditorInfo.IME_ACTION_DONE -> {
                    LogInButton.performClick()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    fun btnPressed(view: View) {
        when (view.id) {

            R.id.LogInButton -> {
                if (Password.text.toString().isEmpty()) {
                    alertBox.text = getString(R.string.PasswordAlert)
                } else if (Login.text.toString().isEmpty()) {
                    alertBox.text = getString(R.string.LoginAlert)
                } else {
                    alertBox.text = getString(R.string.Alert)
                }
            }

            R.id.changeThemeButton -> {
                when (resources.configuration.uiMode and UI_MODE_NIGHT_MASK) {
                    UI_MODE_NIGHT_NO -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    }
                    UI_MODE_NIGHT_YES -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    }
                }
            }
        }
    }

}