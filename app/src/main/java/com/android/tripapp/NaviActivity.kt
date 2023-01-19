package com.android.tripapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.android.tripapp.databinding.ActivityNaviBinding
import androidx.fragment.app.FragmentTransaction

private const val TAG_HOME = "home_fragment"
private const val TAG_PLAN = "plan_fragment"
private const val TAG_WEATHER = "weather_fragment"
private const val TAG_MY_PLAN = "my_plan_fragment"
private const val TAG_MY_PAGE = "my_page_fragment"

class NaviActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNaviBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_navi)

        binding.navigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.HomeFragment -> setFragment(TAG_HOME, HomeFragment())
                R.id.PlanFragment -> setFragment(TAG_PLAN, PlanFragment())
                R.id.WeatherFragment -> setFragment(TAG_WEATHER, WeatherFragment())
                R.id.MyPlanFragment -> setFragment(TAG_MY_PLAN, MyPlanFragment())
                R.id.MyPageFragment -> setFragment(TAG_MY_PAGE, MyPageFragment())
            }
            true
        }
    }
    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null){
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }

        val home = manager.findFragmentByTag(TAG_HOME)
        val plan = manager.findFragmentByTag(TAG_PLAN)
        val weather= manager.findFragmentByTag(TAG_WEATHER)
        val myPlan = manager.findFragmentByTag(TAG_MY_PLAN)
        val myPage = manager.findFragmentByTag(TAG_MY_PAGE)

        if (home != null) {
            fragTransaction.hide(home)
        }
        if (plan != null) {
            fragTransaction.hide(plan)
        }
        if (weather != null) {
            fragTransaction.hide(weather)
        }
        if (myPlan != null) {
            fragTransaction.hide(myPlan)
        }
        if (myPage != null) {
            fragTransaction.hide(myPage)
        }

        if(tag == TAG_HOME) {
            if(home!=null) {
                fragTransaction.show(home)
            }
        }
        else if(tag == TAG_PLAN) {
            if(plan!=null) {
                fragTransaction.show(plan)
            }
        }
        else if(tag == TAG_WEATHER) {
            if(weather!=null) {
                fragTransaction.show(weather)
            }
        }
        else if(tag == TAG_MY_PLAN) {
            if(myPlan!=null) {
                fragTransaction.show(myPlan)
            }
        }
        else if(tag == TAG_MY_PAGE) {
            if(myPage!=null) {
                fragTransaction.show(myPage)
            }
        }
        fragTransaction.commitAllowingStateLoss();
    }
}