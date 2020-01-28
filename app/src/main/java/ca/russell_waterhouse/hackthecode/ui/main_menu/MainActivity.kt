package ca.russell_waterhouse.hackthecode.ui.main_menu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.russell_waterhouse.hackthecode.R
import ca.russell_waterhouse.hackthecode.ui.level_selection.LevelSelectionActivity

class MainActivity : AppCompatActivity(),
    MainMenuFragment.OnMainMenuFragmentInteractionListener,
    AboutAppFragment.OnAboutAppFragmentInteractionListener,
    InstructionsFragment.OnInstructionsFragmentInteractionListener {
    private val mainMenuTAG = "MAIN_MENU"
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
                .add(R.id.main_container, AboutAppFragment.newInstance(), aboutAppTAG).commit()
        }
    }

    override fun instructionsButtonPressed() {
        val mainMenuFragment = supportFragmentManager.findFragmentByTag(mainMenuTAG)
        if (mainMenuFragment != null){
            supportFragmentManager.beginTransaction().hide(mainMenuFragment)
                .add(R.id.main_container, InstructionsFragment.newInstance(), instructionsTAG).commit()
        }
    }

    override fun levelSelectButtonPressed() {
        startActivity(Intent(applicationContext, LevelSelectionActivity::class.java))
    }
}
