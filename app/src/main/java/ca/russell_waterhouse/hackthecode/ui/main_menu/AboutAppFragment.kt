package ca.russell_waterhouse.hackthecode.ui.main_menu

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ca.russell_waterhouse.hackthecode.R


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AboutAppFragment.OnAboutAppFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AboutAppFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutAppFragment : Fragment() {
    private var listenerAboutApp: OnAboutAppFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_app, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnAboutAppFragmentInteractionListener) {
            listenerAboutApp = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listenerAboutApp = null
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
    interface OnAboutAppFragmentInteractionListener {
//        TODO("update with interface as needed")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment AboutAppFragment.
         */
        @JvmStatic
        fun newInstance() =
            AboutAppFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
