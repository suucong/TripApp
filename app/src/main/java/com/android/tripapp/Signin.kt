package com.android.tripapp

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class Signin : AppCompatActivity() {

    lateinit var edtEmail_Si : EditText
    lateinit var edtPassword_Si : EditText
    lateinit var edtRePassword_Si : EditText
    lateinit var tvSelectBirth_Si : TextView
    lateinit var btnCalendar_Si : Button
    lateinit var btnBackToLogin_Si : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        edtEmail_Si = findViewById(R.id.edtEmail_Si)
        edtPassword_Si = findViewById(R.id.edtRePassword_Si)
        edtRePassword_Si = findViewById(R.id.edtRePassword_Si)
        tvSelectBirth_Si = findViewById(R.id.tvSelectBirth_Si)
        btnCalendar_Si = findViewById(R.id.btnCalendar_Si)
        btnBackToLogin_Si = findViewById(R.id.btnBackToLogin_Si)

        // 달력 버튼 클릭 이벤트
        btnCalendar_Si.setOnClickListener {
            showDatePicker()
        }

        // 로그인 화면으로 돌아가는 버튼 리스너
        btnBackToLogin_Si.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    // 달력 보여주고 textView에 입력하기 함수
    private fun showDatePicker() {
        val calendar : Calendar = Calendar.getInstance()

        val iYear = calendar.get(Calendar.YEAR) // 년
        val iMonth = calendar.get(Calendar.MONTH) // 월
        val iDay = calendar.get(Calendar.DAY_OF_MONTH) // 일

        // 달력 호출
        val datePicker : DatePickerDialog = DatePickerDialog(this,
        DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->

            // 1월은 0부터 시작해서 +1 해줌
            val tMonth : Int = month + 1

            // 년, 월, 일
            val date : String = "$year / $tMonth / $day"

            // textview에 선택한 날짜 입력
            tvSelectBirth_Si.text = date
        }, iYear, iMonth, iDay)

        // 달력 호출
        datePicker.show()
    }
}