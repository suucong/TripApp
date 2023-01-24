package com.android.tripapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.android.tripapp.databinding.ActivityNaviBinding
import com.google.firebase.auth.FirebaseAuth

class NaviActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNaviBinding
    private lateinit var user: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = FirebaseAuth.getInstance()

        changeFragment(HomeFragment())

        if(user.currentUser == null) {
            user.currentUser?.let {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

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