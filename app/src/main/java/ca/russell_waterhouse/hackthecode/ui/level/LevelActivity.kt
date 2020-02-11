package ca.russell_waterhouse.hackthecode.ui.level

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import ca.russell_waterhouse.hackthecode.HackTheCodeApplication
import ca.russell_waterhouse.hackthecode.R
import ca.russell_waterhouse.hackthecode.dependency_injection.LevelComponent
import ca.russell_waterhouse.hackthecode.model.Model
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val levelKEY = "level_to_load"

class LevelActivity : AppCompatActivity(), LevelFragment.OnLevelFragmentInteractionListener {
    private val levelFragmentTAG = "Level Fragment"
    lateinit var levelComponent: LevelComponent

    @Inject
    lateinit var mModel: Model

    companion object {
        @JvmStatic
        fun getIntent(context: Context, level: Int): Intent{
            val intent = Intent(context, LevelActivity::class.java)
            intent.putExtra(levelKEY, level)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        levelComponent = (applicationContext as HackTheCodeApplication).appComponent.levelComponent().create()
        levelComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)
        val currentLevel = intent.getIntExtra(levelKEY, 1)
        mModel.setLevel(currentLevel)
        setupActionBar()
        supportFragmentManager.beginTransaction().add(R.id.level_container,
            LevelFragment.newInstance(mModel.getLevelWord(this)),
            levelFragmentTAG).commit()
    }

    private fun setupActionBar() {
        val hintButton = findViewById<TextView>(R.id.hint_button)
        hintButton.text = getString(R.string.hint)
        hintButton.setTextColor(getColor(R.color.colorNeutral))
        hintButton.gravity = Gravity.END
        hintButton.setOnClickListener {
            val hint = mModel.getHint(this)
            val rootLayout = findViewById<ConstraintLayout>(R.id.root_layout_level)
            Snackbar.make(rootLayout, hint, Snackbar.LENGTH_LONG).show()
        }
        val toolBar = findViewById<Toolbar>(R.id.toolbar)
        toolBar.title = getString(R.string.empty_string)
        val toolbarTitle = findViewById<TextView>(R.id.toolbar_title)
        val level = mModel.getLevel()
        toolbarTitle.text = getString(R.string.level_title, level)
        setSupportActionBar(toolBar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun testString(string: String){
        val result = mModel.testString(this, string)
        if (result){
            val sharedPreferences = getSharedPreferences(getString(R.string.preferences_key), Context.MODE_PRIVATE)
            val currentLevel = mModel.getLevel()
            var currentMaxLevel = sharedPreferences.getInt(getString(R.string.maximum_level_key), 1)
            if (currentLevel == currentMaxLevel){
                currentMaxLevel++
                with(sharedPreferences.edit()){
                    putInt(getString(R.string.maximum_level_key), currentMaxLevel)
                    commit()
                }
            }
            Toast.makeText(this, R.string.feedback_level_complete, Toast.LENGTH_LONG).show()
            finish()
        }
        else{
            Toast.makeText(this, R.string.try_again, Toast.LENGTH_LONG).show()
        }
    }

    override fun encodeString(string: String){
        GlobalScope.launch {
            mModel.encodeWord(string)
        }
        val inputMethodManager: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}
