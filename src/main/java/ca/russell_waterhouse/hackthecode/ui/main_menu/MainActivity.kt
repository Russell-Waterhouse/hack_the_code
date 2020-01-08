package ca.russell_waterhouse.hackthecode.ui.main_menu

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ca.russell_waterhouse.hackthecode.R
import ca.russell_waterhouse.hackthecode.ui.level.LevelActivity

class MainActivity : AppCompatActivity(),
    MainMenuFragment.OnMainMenuFragmentInteractionListener,
    LevelSelectFragment.OnLevelSelectionFragmentInteractionListener {
    private val mainMenuTAG = "MAIN_MENU"
    private val levelSelectTAG = "SELECT_LEVEL"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.main_container, MainMenuFragment.newInstance(), mainMenuTAG).commit()
    }

    override fun aboutAppButtonPressed() {
        Toast.makeText(this, "about app button pressed", Toast.LENGTH_SHORT).show()
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun instructionsButtonPressed() {
        Toast.makeText(this, "instructions button pressed", Toast.LENGTH_SHORT).show()
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun levelSelectButtonPressed() {
        val mainMenuFragment = supportFragmentManager.findFragmentByTag(mainMenuTAG)
        val preferencesFileKey= getString(R.string.preferences_key)
        val preferences = getSharedPreferences(preferencesFileKey, Context.MODE_PRIVATE)
        val maxLevelKey = getString(R.string.maximum_level_key)
        val maxLevel = preferences.getInt(maxLevelKey, 1)
        if (mainMenuFragment != null) {
            supportFragmentManager.beginTransaction().hide(mainMenuFragment)
                .add(R.id.main_container, LevelSelectFragment.newInstance(maxLevel), levelSelectTAG).commit()
        }
    }

    override fun levelSelected(level: Int) {
        val levelIntent = LevelActivity.getIntent(this, level)
        startActivity(levelIntent)
    }
}
