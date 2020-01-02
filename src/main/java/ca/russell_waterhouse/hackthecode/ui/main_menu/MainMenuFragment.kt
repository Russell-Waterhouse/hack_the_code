package ca.russell_waterhouse.hackthecode.ui.main_menu

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import ca.russell_waterhouse.hackthecode.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MainMenuFragment.OnMainMenuFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MainMenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainMenuFragment : Fragment() {
    private var listener: OnMainMenuFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val mainMenu = inflater.inflate(R.layout.fragment_main_menu, container, false)
        initViews(mainMenu)
        return mainMenu
    }

    private fun initViews(parent: View){
        val levelSelectButton = parent.findViewById<Button>(R.id.select_level_button)
        levelSelectButton.setOnClickListener{
            listener?.levelSelectButtonPressed()
        }
        val instructionsButton = parent.findViewById<Button>(R.id.instructions_button)
        instructionsButton.setOnClickListener{
            listener?.instructionsButtonPressed()
        }
        val aboutAppButton = parent.findViewById<Button>(R.id.about_app_button)
        aboutAppButton.setOnClickListener{
            listener?.aboutAppButtonPressed()
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMainMenuFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
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
    interface OnMainMenuFragmentInteractionListener {
        fun levelSelectButtonPressed()
        fun aboutAppButtonPressed()
        fun instructionsButtonPressed()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment MainMenuFragment.
         */
        @JvmStatic
        fun newInstance() =
            MainMenuFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
