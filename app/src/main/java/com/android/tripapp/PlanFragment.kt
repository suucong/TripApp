package com.android.tripapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PlanFragment : Fragment() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    lateinit var btnAddPlan : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_plan, container, false)
        viewPager = view.findViewById(R.id.planViewPager)
        tabLayout = view.findViewById(R.id.planTab)
        btnAddPlan = view.findViewById(R.id.btnAddPlan_Pn)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val planPagerAdapter = PlanPagerAdapter(requireActivity())
        // 2개의 fragment add
        planPagerAdapter.addFragment(PlanNextFragment(), "예정된 계획")
        planPagerAdapter.addFragment(PlanPrevFragment(), "지난 계획")


        // adapter
        viewPager.adapter = planPagerAdapter
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int){
                super.onPageSelected(position)
                Log.e("ViewPagerFragment", "Page ${position+1}")
            }
        })

        // tablayout attach
        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
            when (position) {
                0 -> tab.text = "예정된 계획"
                1 -> tab.text = "지난 계획"
            }
        }.attach()

        // AddPlan button click event
        btnAddPlan.setOnClickListener {
            activity?.let{
                val intent = Intent(context, PlanTripActivity::class.java)
                startActivity(intent)
            }
        }
    }
}