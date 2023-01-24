package com.android.tripapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PlanWhenActivity : AppCompatActivity() {

    lateinit var btnPrev_when : Button
    lateinit var btnNext_when : Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan_when)

        btnPrev_when = findViewById(R.id.btnPrev_Pnwn)
        btnNext_when = findViewById(R.id.btnNext_Pnwn)

        btnPrev_when.setOnClickListener {
            var intent = Intent(this, PlanWhereActivity::class.java)
            startActivity(intent)
        }
    }
}