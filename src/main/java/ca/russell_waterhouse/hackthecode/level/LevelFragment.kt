package ca.russell_waterhouse.hackthecode.level

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ca.russell_waterhouse.hackthecode.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [LevelFragment.OnLevelFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [LevelFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LevelFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var decodedString: String? = null
    private var encodedString: String? = null
    private var listenerLevel: OnLevelFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            decodedString = it.getString(ARG_PARAM1)
            encodedString = it.getString(ARG_PARAM2)
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

    fun initializeViews(parent: View){
        val encodedTV = parent.findViewById<TextView>(R.id.encoded_textview)
        encodedTV.setText(encodedString)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listenerLevel?.onFragmentInteraction(uri)
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
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
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
                    putString(ARG_PARAM1, decodedString)
                    putString(ARG_PARAM2, encodedString)
                }
            }
    }
}
