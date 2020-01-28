package ca.russell_waterhouse.hackthecode.ui.level_selection

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import ca.russell_waterhouse.hackthecode.R
import ca.russell_waterhouse.hackthecode.ui.level.LevelActivity

class LevelSelectionActivity : AppCompatActivity(),
    LevelSelectFragment.OnLevelSelectionFragmentInteractionListener {

    private val levelSelectTAG = "SELECT_LEVEL"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_selection)

        val toolbar = findViewById<Toolbar>(R.id.level_select_toolbar)
        toolbar.title = getString(R.string.select_level_prompt)
        if (toolbar!= null) {
            setSupportActionBar(toolbar)
        }
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val preferencesFileKey= getString(R.string.preferences_key)
        val preferences = getSharedPreferences(preferencesFileKey, Context.MODE_PRIVATE)
        val maxLevelKey = getString(R.string.maximum_level_key)
        val maxLevel = preferences.getInt(maxLevelKey, 1)
        supportFragmentManager.beginTransaction().add(R.id.level_selection_container,
            LevelSelectFragment.newInstance(maxLevel), levelSelectTAG).commit()
    }

    override fun levelSelected(level: Int) {
        val levelIntent = LevelActivity.getIntent(applicationContext, level)
        startActivity(levelIntent)
        finish()
    }
}
