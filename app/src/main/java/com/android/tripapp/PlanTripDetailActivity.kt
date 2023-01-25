package com.android.tripapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup.LayoutParams
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class PlanTripDetailActivity : AppCompatActivity() {

    lateinit var linearLayoutPlan : LinearLayout

    lateinit var tvPlanTitle : TextView
    lateinit var tvPLanDate : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan_trip_detail)

        linearLayoutPlan = findViewById(R.id.LinearLayoutPlan_Ptd)
        tvPlanTitle = findViewById(R.id.tvPlanTitle_Ptd)
        tvPLanDate = findViewById(R.id.tvPlanDate_Ptd)

        val planTitle = intent.getStringExtra("planTitle")
        val planDate = intent.getStringExtra("planDate")
        val dateDiff = intent.getStringExtra("dateDiff")

        tvPlanTitle.text = "$planTitle"
        tvPLanDate.text = "$planDate"

        if (dateDiff != null) {
            for (i : Int in 1..dateDiff.toInt()) {
            //    addView(i)
                val params_mw: LinearLayout.LayoutParams =
                    LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
                    )

                val params_ww: LinearLayout.LayoutParams =
                    LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
                    )

                val ll_main = LinearLayout(this)
                ll_main.layoutParams = params_mw
                ll_main.orientation = LinearLayout.VERTICAL

                val day_n = TextView(this)
                day_n.text = "${i}일차"

                val ll_sub = LinearLayout(this)
                ll_sub.layoutParams = params_mw
                ll_sub.orientation = LinearLayout.HORIZONTAL

                val checkBox = CheckBox(this)

                val editText = EditText(this)
                editText.hint = "가고자 하는 장소를 입력하세요"

                var button = Button(this)
                button.setText("+")
                button.layoutParams = params_ww

                val addPlanIcon = LayoutInflater.from(this).inflate(R.layout.add_plan_icon,null,false)
                addPlanIcon.findViewById<EditText>(R.id.edtHowToMove)
                addPlanIcon.findViewById<EditText>(R.id.edtWhereToGo)


                ll_main.addView(day_n)
                ll_sub.addView(checkBox)
                ll_sub.addView(editText)
                ll_main.addView(ll_sub)
                ll_main.addView(button)
                linearLayoutPlan.addView(ll_main)
            }

        }
    }

    fun addView(i : Int) {

        val params_mw: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
            )

        val params_ww: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
            )

        val ll_main = LinearLayout(this)
        ll_main.layoutParams = params_mw
        ll_main.orientation = LinearLayout.VERTICAL

        val day_n = TextView(this)
        day_n.text = "${i}일차"

        val ll_sub = LinearLayout(this)
        ll_sub.layoutParams = params_mw
        ll_sub.orientation = LinearLayout.HORIZONTAL

        val checkBox = CheckBox(this)

        val editText = EditText(this)
        editText.hint = "가고자 하는 장소를 입력하세요"

        val button = Button(this)
        button.setText("+")
        button.layoutParams = params_ww

        val addPlanIcon = LayoutInflater.from(this).inflate(R.layout.add_plan_icon,null,false)
        addPlanIcon.findViewById<EditText>(R.id.edtHowToMove)
        addPlanIcon.findViewById<EditText>(R.id.edtWhereToGo)


        ll_main.addView(day_n)
        ll_sub.addView(checkBox)
        ll_sub.addView(editText)
        ll_main.addView(ll_sub)
        ll_main.addView(button)
        linearLayoutPlan.addView(ll_main)
    }
}