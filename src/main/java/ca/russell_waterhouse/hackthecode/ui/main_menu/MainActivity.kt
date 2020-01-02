package ca.russell_waterhouse.hackthecode.ui.main_menu

import android.content.Intent
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
        val currentFragment = supportFragmentManager.findFragmentByTag(mainMenuTAG)
        if (currentFragment != null) {
            supportFragmentManager.beginTransaction().hide(currentFragment).add(R.id.main_container, LevelSelectFragment.newInstance(1), levelSelectTAG).commit()
        }
    }

    override fun levelSelected(level: Int) {
        val levelIntent = LevelActivity.getIntent(this, level)
        startActivity(levelIntent)
    }


}
