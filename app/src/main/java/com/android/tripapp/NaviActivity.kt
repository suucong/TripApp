package com.android.tripapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.android.tripapp.databinding.ActivityNaviBinding
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationBarView

class NaviActivity : AppCompatActivity() {

    private lateinit var homeFragment: Fragment
    private lateinit var planFragment: Fragment
    private lateinit var weatherFragment: Fragment
    private lateinit var tripLogFragment: Fragment
    private lateinit var myPageFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navi)

        homeFragment = HomeFragment()
        planFragment = PlanFragment()
        weatherFragment = WeatherFragment()
        tripLogFragment = TripLogFragment()
        myPageFragment = MyPageFragment()

        supportFragmentManager.beginTransaction().replace(R.id.navigationView, planFragment).commit()

        val bottomnavigationView = findViewById(R.id.navigationView) as NavigationBarView
        bottomnavigationView.setOnItemSelectedListener (
            object: NavigationBarView.OnItemSelectedListener {
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    var selectedFragment: Fragment ?= null
                    when(item.itemId) {
                        R.id.HomeFragment -> selectedFragment = homeFragment
                        R.id.PlanFragment -> selectedFragment = planFragment
                        R.id.WeatherFragment -> selectedFragment = weatherFragment
                        R.id.TripLogFragment -> selectedFragment = tripLogFragment
                        R.id.MyPageFragment -> selectedFragment = myPageFragment
                    }
                    selectedFragment?.let {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.navigationView, selectedFragment)
                            .commit()
                        return true
                    }
                    return false
                }
            }
        )
    }
}