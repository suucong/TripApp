package com.android.tripapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PlanPrevFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlanPrevFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plan_prev, container, false)
    }

    private fun newInstant() : PlanPrevFragment
    {
        val args = Bundle()
        val frag = PlanPrevFragment()
        frag.arguments = args
        return frag
    }
}