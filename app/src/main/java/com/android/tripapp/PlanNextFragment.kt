package com.android.tripapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class PlanNextFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plan_next, container, false)
    }

    private fun newInstant() : PlanNextFragment
    {
        val args = Bundle()
        val frag = PlanNextFragment()
        frag.arguments = args
        return frag
    }
}