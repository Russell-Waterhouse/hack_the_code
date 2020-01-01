package ca.russell_waterhouse.hackthecode.level

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.russell_waterhouse.hackthecode.R

class LevelActivity : AppCompatActivity(), LevelFragment.OnLevelFragmentInteractionListener {
    val levelFragmentTAG = "Level Fragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)
        val fragManager = this.supportFragmentManager
//        TODO: put in the proper strings into the levelFragment.newINstance method
        fragManager.beginTransaction().add(R.id.level_container,
            LevelFragment.newInstance("Translate this sentence", "tr1nsl1t2 th3s s2nt2nc2"),
            levelFragmentTAG).commit()
    }

    override fun testString(string: String){
//        TODO: Finish function
    }


}
