package com.android.tripapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PlanTripDetailActivity : AppCompatActivity() {

    lateinit var tvPlanTitle : TextView
    lateinit var tvPLanDate : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan_trip_detail)

        tvPlanTitle = findViewById(R.id.tvPlanTitle_Ptd)
        tvPLanDate = findViewById(R.id.tvPlanDate_Ptd)

        val planTitle = intent.getStringExtra("planTitle")
        val planDate = intent.getStringExtra("planDate")

        tvPlanTitle.text = "$planTitle"
        tvPLanDate.text = "$planDate"
    }
}