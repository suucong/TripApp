package com.android.tripapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PlanPagerAdapter (fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){
    var fragments : ArrayList<Fragment> = ArrayList()
    var titleList : ArrayList<String> = ArrayList()

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun addFragment(fragment : Fragment, title : String){
        fragments.add(fragment)
        notifyItemInserted(fragments.size - 1)
        titleList.add(title)
    }

    fun removeFragment(){
        fragments.removeLast()
        notifyItemRemoved(fragments.size)
    }
}
