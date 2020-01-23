package ca.russell_waterhouse.hackthecode.ui.level

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ca.russell_waterhouse.hackthecode.R
import ca.russell_waterhouse.hackthecode.model.Model
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private const val levelKEY = "level_to_load"

class LevelActivity : AppCompatActivity(), LevelFragment.OnLevelFragmentInteractionListener {
    private val levelFragmentTAG = "Level Fragment"
    private lateinit var model: Model

    companion object {
        @JvmStatic
        fun getIntent(context: Context, level: Int): Intent{
            val intent = Intent(context, LevelActivity::class.java)
            intent.putExtra(levelKEY, level)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)
        if (!::model.isInitialized){
            model = Model(application)
        }
        val currentLevel = intent.getIntExtra(levelKEY, 1)
        model.setLevel(currentLevel)
        val fragManager = this.supportFragmentManager
        fragManager.beginTransaction().add(R.id.level_container,
            LevelFragment.newInstance("Translate this sentence", "tr1nsl1t2 th3s s2nt2nc2"),
            levelFragmentTAG).commit()
    }

    override fun testString(string: String){
        val result = model.testString(this, string)
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
        Toast.makeText(this, hint, Toast.LENGTH_LONG).show()
    }

    override fun encodeString(string: String){
        GlobalScope.launch {
            model.encodeWord(string)
        }
    }

    override fun getModel(): Model {
        return model
    }
}
