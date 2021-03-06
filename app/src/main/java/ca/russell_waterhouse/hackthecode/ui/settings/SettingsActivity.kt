package ca.russell_waterhouse.hackthecode.ui.settings

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ca.russell_waterhouse.hackthecode.HackTheCodeApplication
import ca.russell_waterhouse.hackthecode.R
import ca.russell_waterhouse.hackthecode.dependency_injection.SettingsComponent
import ca.russell_waterhouse.hackthecode.model.Model
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class SettingsActivity : AppCompatActivity(), SettingsFragment.OnSettingsFragmentInteractionListener {

    private lateinit var settingsComponent: SettingsComponent

    @Inject
    lateinit var model: Model

    override fun onCreate(savedInstanceState: Bundle?) {
        val appComponent = (applicationContext as HackTheCodeApplication).appComponent
        settingsComponent = appComponent.settingsComponent().create()
        settingsComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        supportFragmentManager.beginTransaction().add(R.id.settings_container, SettingsFragment.newInstance()).commit()
        setSupportActionBar(findViewById(R.id.settings_toolbar))
        supportActionBar?.title = getString(R.string.settings)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.show()
    }

    override fun resetLevels() {
        deleteAllFromDatabase()
        Toast.makeText(applicationContext, R.string.feedback_app_reset, Toast.LENGTH_LONG).show()
        GlobalScope.launch {
            val preferences =
                getSharedPreferences(getString(R.string.preferences_key), Context.MODE_PRIVATE)
            preferences.edit().putInt(getString(R.string.maximum_level_key), 1).apply()
        }
        finish()
    }

    override fun deleteAllFromDatabase() {
        Toast.makeText(applicationContext, R.string.feedback_guesses_removed, Toast.LENGTH_LONG).show()
        GlobalScope.launch {
            model.deleteAllFromDatabase()
        }
    }
}
