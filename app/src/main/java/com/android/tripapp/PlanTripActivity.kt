package com.android.tripapp

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class PlanTripActivity : AppCompatActivity() {

    lateinit var btnBackPlan : Button
    lateinit var btnCalendarGo : Button
    lateinit var btnCalendarCome : Button
    lateinit var btnNext : Button

    lateinit var tvDateGo : TextView
    lateinit var tvDateCome : TextView
    lateinit var edtTitle : EditText

    private lateinit var selectDateGo : Calendar
    private lateinit var selectDateCome : Calendar
    val calendar : Calendar = Calendar.getInstance()

    val iYear = calendar.get(Calendar.YEAR) // 년
    val iMonth = calendar.get(Calendar.MONTH) // 월
    val iDay = calendar.get(Calendar.DAY_OF_MONTH) // 일

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan_trip)

        btnBackPlan = findViewById(R.id.btnBackPlan_Pt)
        btnCalendarGo = findViewById(R.id.btnCalendarGo_Pt)
        btnCalendarCome = findViewById(R.id.btnCalendarCome_Pt)
        btnNext = findViewById(R.id.btnNext_Pt)

        tvDateGo = findViewById(R.id.tvDateGo_Pt)
        tvDateCome = findViewById(R.id.tvDateCome_Pt)
        edtTitle = findViewById(R.id.edtTitle_Pt)

        // 가는 날 달력 버튼 클릭 이벤트
        btnCalendarGo.setOnClickListener {
            // 달력 호출
            val datePicker : DatePickerDialog = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                    // 선택한 날짜 저장
                    selectDateGo = Calendar.getInstance().apply { set(year, month, day) }

                    // 1월은 0부터 시작해서 +1 해줌
                    val tMonth : Int = month + 1

                    // 년, 월, 일
                    val date : String = "$year / $tMonth / $day"

                    // textview에 선택한 날짜 입력
                    tvDateGo.text = date
                }, iYear, iMonth, iDay).apply {
                    // 오늘 날짜보다 이전 날짜 선택할 수 없도록 함
                    datePicker.minDate = System.currentTimeMillis()
            }

            // 달력 호출
            datePicker.show()
        }

        // 오는 날 달력 버튼 클릭 이벤트
        btnCalendarCome.setOnClickListener {
            // 달력 호출
            val datePicker : DatePickerDialog = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                    // 선택한 날짜 저장
                    selectDateCome = Calendar.getInstance().apply { set(year, month, day) }

                    // 1월은 0부터 시작해서 +1 해줌
                    val tMonth : Int = month + 1

                    // 년, 월, 일
                    val date : String = "$year / $tMonth / $day"

                    // textview에 선택한 날짜 입력
                    tvDateCome.text = date
                }, iYear, iMonth, iDay).apply {
                    // 가는 날보다 이전 날짜 선택할 수 없도록 함.
                    datePicker.minDate = selectDateGo.timeInMillis
            }

            // 달력 호출
            datePicker.show()
        }

        // 다음 버튼 클릭 이벤트
        btnNext.setOnClickListener {
            val planTitle : String = edtTitle.text.toString()
            val planDate : String = "${tvDateGo.text} ~ ${tvDateCome.text}"
            val dateDiff : String
                = "${(selectDateCome.timeInMillis-selectDateGo.timeInMillis) / (24*60*60*1000) + 1}"

            var intent = Intent(this, PlanTripDetailActivity::class.java)
            intent.putExtra("planTitle", planTitle)
            intent.putExtra("planDate", planDate)
            intent.putExtra("dateDiff", dateDiff)
            startActivity(intent)
        }
    }
}
