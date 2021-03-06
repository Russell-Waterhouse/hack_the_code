package ca.russell_waterhouse.hackthecode.ui.instructions

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ca.russell_waterhouse.hackthecode.R


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [InstructionsFragment.OnInstructionsFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [InstructionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InstructionsFragment : Fragment() {
    private var listener: OnInstructionsFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_instructions, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnInstructionsFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
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
    interface OnInstructionsFragmentInteractionListener

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment instructionsFragment.
         */
        @JvmStatic
        fun newInstance() =
            InstructionsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
