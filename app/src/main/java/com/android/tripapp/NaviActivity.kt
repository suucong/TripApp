package com.android.tripapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.android.tripapp.databinding.ActivityMainBinding
import com.android.tripapp.databinding.ActivityNaviBinding

class NaviActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.HomeFragment -> changeFragment(HomeFragment())
                R.id.PlanFragment -> changeFragment(PlanFragment())
                R.id.WeatherFragment -> changeFragment(WeatherFragment())
                R.id.TripLogFragment -> changeFragment(TripLogFragment())
                R.id.MyPageFragment -> changeFragment(MyPageFragment())
            }
            true
        }
    }

    private fun changeFragment(fragment : Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainFrameLayout, fragment)
            .commit()
    }

}