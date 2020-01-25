package ca.russell_waterhouse.hackthecode.ui.main_menu.level_selection

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import ca.russell_waterhouse.hackthecode.R

class LevelListAdapter(context: Context, private val resource: Int) : ArrayAdapter<Int>(context, resource) {

    private val count = 8
    private var levels: IntArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)

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
        gridElement.tag = position+1
        val levelText = gridElement.findViewById<TextView>(R.id.grid_element_text)
        levelText.text = (position+1).toString()
        gridElement.setOnClickListener{
            Toast.makeText(context, gridElement.tag.toString(), Toast.LENGTH_LONG).show()
        }
        return gridElement
    }

    override fun getCount(): Int {
        return count
    }
}