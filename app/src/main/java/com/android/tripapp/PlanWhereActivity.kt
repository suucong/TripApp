package com.android.tripapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PlanWhereActivity : AppCompatActivity() {

    lateinit var btnBackPlan : Button
    lateinit var btnNext_where : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan_where)

        btnBackPlan = findViewById(R.id.btnBackPlan_Pnwr)
    //    btnNext_where = findViewById(R.id.btnNext_Pnwr)

//        btnNext_where.setOnClickListener {
//            var intent = Intent(this, PlanWhenActivity::class.java)
//            startActivity(intent)
//        }

//        btnBackPlan.setOnClickListener{
//            var intent = Intent(this, NaviActivity::class.java)
//            startActivity(intent)
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.bottom_navigation_view, PlanFragment())
//                .commit()
//        }
    }
}
