package ca.russell_waterhouse.hackthecode.ui.instructions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import ca.russell_waterhouse.hackthecode.R

class InstructionsActivity : AppCompatActivity(),
    InstructionsFragment.OnInstructionsFragmentInteractionListener {

    private val instructionsTAG = "INSTRUCTIONS"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructions)
        val toolbar = findViewById<Toolbar>(R.id.instructions_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title = getString(R.string.instructions)
        supportActionBar?.show()

        supportFragmentManager.beginTransaction().add(R.id.instructions_container,
            InstructionsFragment.newInstance(), instructionsTAG).commit()
    }
}
