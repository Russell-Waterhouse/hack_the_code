package ca.russell_waterhouse.hackthecode.ui.main_menu

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.gridlayout.widget.GridLayout

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
        val levelSelection = inflater.inflate(R.layout.fragment_level_select, container, false)
        initViews(levelSelection)
        // Inflate the layout for this fragment
        return levelSelection
    }

    private fun initViews(parent: View){
        val levels = parent.findViewById<GridLayout>(R.id.level_grid)
        var i = 0
        while(i < levels.childCount){
            val levelButton = levels.getChildAt(i)
            levelButton.setOnClickListener{
//                TODO: This always passes 8 or 1 (???) as a parameter to the method below. fix that
                listenerLevelSelection?.levelSelected(i)
            }
            i++
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnLevelSelectionFragmentInteractionListener) {
            listenerLevelSelection = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
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
