package ca.russell_waterhouse.hackthecode.ui.level_selection

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import ca.russell_waterhouse.hackthecode.R

class LevelListAdapter(context: Context, private val resource: Int, private val maxUnlockedLevel: Int)
    : ArrayAdapter<Int>(context, resource) {

    private val count = 8

    override fun isEmpty(): Boolean {
        return false
    }

    override fun getItem(position: Int): Int? {
        return position + 1
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater= context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val gridElement = inflater.inflate(resource, parent, false)
        val levelText = gridElement.findViewById<TextView>(R.id.grid_element_text)
        levelText.text = (position+1).toString()
        levelText.gravity = Gravity.CENTER_VERTICAL
        levelText.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
        levelText.layoutParams.height = 150
        when {
            position + 1 > maxUnlockedLevel ->
                levelText.background = context.getDrawable(R.drawable.ic_lock_black_24dp)
            position + 1 == maxUnlockedLevel ->
                levelText.background = context.getDrawable(R.drawable.rounded_corners_accent)
            position + 1 < maxUnlockedLevel ->
                levelText.background = context.getDrawable(R.drawable.rounded_corners_primary)
        }
        return gridElement
    }

    override fun getCount(): Int {
        return count
    }
}