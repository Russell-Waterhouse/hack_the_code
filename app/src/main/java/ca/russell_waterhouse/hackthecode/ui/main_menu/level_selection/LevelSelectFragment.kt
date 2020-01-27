package ca.russell_waterhouse.hackthecode.ui.main_menu.level_selection

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import ca.russell_waterhouse.hackthecode.R

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val CURRENT_LEVEL = "param1"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [LevelSelectFragment.OnLevelSelectionFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [LevelSelectFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LevelSelectFragment : Fragment() {
    private var currentLevel: Int = 0
    private var listenerLevelSelection: OnLevelSelectionFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            currentLevel = it.getInt(CURRENT_LEVEL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView = inflater.inflate(R.layout.fragment_level_select, container, false)
        val levels = fragmentView.findViewById<GridView>(R.id.level_grid)
        val tempContext = context
        if (tempContext!= null){
            levels.adapter = LevelListAdapter(tempContext, R.layout.grid_element)
        }
        levels.numColumns = 4
        levels.setOnItemClickListener { parent, view, position, id ->
            val requestedLevel = position + 1
            listenerLevelSelection?.levelSelected(requestedLevel)
        }
        return fragmentView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnLevelSelectionFragmentInteractionListener) {
            listenerLevelSelection = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listenerLevelSelection = null
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
    interface OnLevelSelectionFragmentInteractionListener {
        fun levelSelected(level: Int)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param currentLevel Parameter 1.
         * @return A new instance of fragment LevelSelectFragment.
         */
        @JvmStatic
        fun newInstance(currentLevel: Int) =
            LevelSelectFragment().apply {
                arguments = Bundle().apply {
                    putInt(CURRENT_LEVEL, currentLevel)
                }
            }
    }
}
