package ca.russell_waterhouse.hackthecode.ui.main_menu

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.russell_waterhouse.hackthecode.R
import ca.russell_waterhouse.hackthecode.ui.level.LevelActivity
import ca.russell_waterhouse.hackthecode.ui.main_menu.level_selection.LevelSelectFragment

class MainActivity : AppCompatActivity(),
    MainMenuFragment.OnMainMenuFragmentInteractionListener,
    LevelSelectFragment.OnLevelSelectionFragmentInteractionListener,
    AboutAppFragment.OnAboutAppFragmentInteractionListener,
    InstructionsFragment.OnInstructionsFragmentInteractionListener {
    private val mainMenuTAG = "MAIN_MENU"
    private val levelSelectTAG = "SELECT_LEVEL"
    private val instructionsTAG = "INSTRUCTIONS"
    private val aboutAppTAG = "ABOUT_APP"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.main_container, MainMenuFragment.newInstance(), mainMenuTAG).commit()
    }

    override fun aboutAppButtonPressed() {
        val mainMenuFragment = supportFragmentManager.findFragmentByTag(mainMenuTAG)
        if (mainMenuFragment != null){
            supportFragmentManager.beginTransaction().hide(mainMenuFragment)
                .add(R.id.main_container, AboutAppFragment.newInstance()).commit()
        }
    }

    override fun instructionsButtonPressed() {
        val mainMenuFragment = supportFragmentManager.findFragmentByTag(mainMenuTAG)
        if (mainMenuFragment != null){
            supportFragmentManager.beginTransaction().hide(mainMenuFragment)
                .add(R.id.main_container, InstructionsFragment.newInstance()).commit()
        }
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
        val levelIntent = LevelActivity.getIntent(applicationContext, level)
        startActivity(levelIntent)
    }
}
