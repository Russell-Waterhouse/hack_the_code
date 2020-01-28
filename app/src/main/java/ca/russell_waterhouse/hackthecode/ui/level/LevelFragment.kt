package ca.russell_waterhouse.hackthecode.ui.level

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import ca.russell_waterhouse.hackthecode.R
import ca.russell_waterhouse.hackthecode.database.Entity
import ca.russell_waterhouse.hackthecode.model.Model

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_ENCODED_STRING = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [LevelFragment.OnLevelFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [LevelFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LevelFragment : Fragment() {
    private var encodedString: String? = null
    private var listenerLevel: OnLevelFragmentInteractionListener? = null
    private lateinit var guessTable: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            encodedString = it.getString(ARG_ENCODED_STRING)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragView = inflater.inflate(R.layout.fragment_level, container, false)
        initializeViews(fragView)
        return fragView
    }

    private fun initializeViews(parent: View){
        val encodedTV = parent.findViewById<TextView>(R.id.encoded_text_view)
        encodedTV.text = encodedString
        val encodedTable = parent.findViewById<TableLayout>(R.id.encoded_table)
        guessTable = encodedTable
        val checkAnswerButton = parent.findViewById<Button>(R.id.check_answer)
        val answerET = parent.findViewById<EditText>(R.id.final_answer)
        checkAnswerButton.setOnClickListener{
            listenerLevel?.testString(answerET.text.toString())
            listenerLevel?.encodeString(answerET.text.toString())
            answerET.setText(R.string.empty_string)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnLevelFragmentInteractionListener) {
            listenerLevel = context
            listenerLevel?.getModel()?.getLiveDataWords()?.observe(this, Observer { newWordList ->
                updateListOfWords(newWordList)
            })
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listenerLevel = null
    }

    private fun updateListOfWords(newWords: List<Entity>){
        guessTable.removeAllViewsInLayout()
        for (item in newWords){
            val newRow = TableRow(context)
            val left = TextView(context)
            val right = TextView(context)
            left.text = item.word
            left.gravity = Gravity.START
            right.text = item.encodedWordL
            right.gravity = Gravity.END
            newRow.addView(left)
            newRow.addView(right)
            guessTable.addView(newRow)
        }

    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnLevelFragmentInteractionListener {
        fun testString(string: String)
        fun encodeString(string: String)
        fun hintRequested()
        fun getModel(): Model
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param encodedString Parameter 2.
         * @return A new instance of fragment LevelFragment.
         */
        @JvmStatic
        fun newInstance(encodedString: String) =
            LevelFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_ENCODED_STRING, encodedString)
                }
            }
    }
}
