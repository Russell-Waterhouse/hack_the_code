package ca.russell_waterhouse.hackthecode.level

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import ca.russell_waterhouse.hackthecode.R
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_DECODED_STRING = "param1"
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
    private var decodedString: String? = null
    private var encodedString: String? = null
    private var listenerLevel: OnLevelFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            decodedString = it.getString(ARG_DECODED_STRING)
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
        val encodedTV = parent.findViewById<TextView>(R.id.encoded_textview)
        encodedTV.text = encodedString
        val hintButton = parent.findViewById<ExtendedFloatingActionButton>(R.id.hint_button)
        hintButton.setOnClickListener{
            listenerLevel?.hintRequested()
        }
        val encodeButton = parent.findViewById<Button>(R.id.encode_button)
        val encodeET = parent.findViewById<EditText>(R.id.string_to_encode_edit_text)
        encodeButton.setOnClickListener{
            listenerLevel?.encodeString(encodeET.text.toString())
        }
        val encodedTable = parent.findViewById<TableLayout>(R.id.encoded_table)
        val row1 = TableRow(context)
        val left = TextView(context)
        left.text = "example sentence"
        left.gravity = Gravity.START
        val right = TextView(context)
        right.text = "2x1mpl2 s2nt2nc2"
        right.gravity = Gravity.END
        row1.addView(left)
        row1.addView(right)
        encodedTable.addView(row1)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnLevelFragmentInteractionListener) {
            listenerLevel = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listenerLevel = null
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
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param decodedString Parameter 1.
         * @param encodedString Parameter 2.
         * @return A new instance of fragment LevelFragment.
         */
        @JvmStatic
        fun newInstance(decodedString: String, encodedString: String) =
            LevelFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_DECODED_STRING, decodedString)
                    putString(ARG_ENCODED_STRING, encodedString)
                }
            }
    }
}
