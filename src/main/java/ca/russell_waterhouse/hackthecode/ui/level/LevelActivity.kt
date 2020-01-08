package ca.russell_waterhouse.hackthecode.ui.level

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import ca.russell_waterhouse.hackthecode.R
import ca.russell_waterhouse.hackthecode.model.Model

private const val levelKEY = "level_to_load"

class LevelActivity : AppCompatActivity(), LevelFragment.OnLevelFragmentInteractionListener {
    private val levelFragmentTAG = "Level Fragment"
    private val model = Model(application)

    companion object {
        fun getIntent(context: Context, level: Int): Intent{
            val intent = Intent(context, LevelActivity::class.java)
            intent.putExtra(levelKEY, level)
//            TODO: get the level number out of the intent
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)
        val fragManager = this.supportFragmentManager
        fragManager.beginTransaction().add(R.id.level_container,
            LevelFragment.newInstance("Translate this sentence", "tr1nsl1t2 th3s s2nt2nc2"),
            levelFragmentTAG).commit()
        model.getLiveDataWords().observe(this, Observer {
                listOfWords -> TODO("need to pass this to the fragment but haven't built the method of the fragment to receive this")
        })
    }

    override fun testString(string: String){
        val result = model.testString(string)
        if (result){
            val sharedPreferences = getSharedPreferences(getString(R.string.preferences_key), Context.MODE_PRIVATE)
            val currentLevel = model.getLevel()
            var currentMaxLevel = sharedPreferences.getInt(getString(R.string.maximum_level_key), 1)
            if (currentLevel == currentMaxLevel){
                currentMaxLevel++
                with(sharedPreferences.edit()){
                    putInt(getString(R.string.maximum_level_key), currentMaxLevel)
                    commit()
                }
            }
        }
        else{
            Toast.makeText(this, R.string.try_again, Toast.LENGTH_LONG).show()
        }
    }

    override fun hintRequested(){
        val hint = model.getHint(this)
        TODO("No place yet built to display hints")
    }

    override fun encodeString(string: String){
        model.encodeWord(string)
    }
}
