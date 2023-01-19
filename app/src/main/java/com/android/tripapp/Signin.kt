package com.android.tripapp

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class Signin : AppCompatActivity() {

    lateinit var dbMemberInfo: DBMemberInfo
    lateinit var sqlitedb : SQLiteDatabase

    lateinit var edtEmail_Si : EditText
    lateinit var edtPassword_Si : EditText
    lateinit var edtRePassword_Si : EditText
    lateinit var tvSelectBirth_Si : TextView
    lateinit var btnCalendar_Si : Button
    lateinit var edtNickName_Si : EditText
    lateinit var btnSignin_Si : Button
    lateinit var btnBackToLogin_Si : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        edtEmail_Si = findViewById(R.id.edtEmail_Si)
        edtPassword_Si = findViewById(R.id.edtPassword_Si)
        edtRePassword_Si = findViewById(R.id.edtRePassword_Si)
        tvSelectBirth_Si = findViewById(R.id.tvSelectBirth_Si)
        btnCalendar_Si = findViewById(R.id.btnCalendar_Si)
        edtNickName_Si = findViewById(R.id.edtNickname_Si)
        btnSignin_Si = findViewById(R.id.btnSignin_Si)
        btnBackToLogin_Si = findViewById(R.id.btnBackToLogin_Si)

        dbMemberInfo = DBMemberInfo(this, "member_infoDB", null, 1)

        // 달력 버튼 클릭 이벤트
        btnCalendar_Si.setOnClickListener {
            showDatePicker()
        }

        // 회원가입 버튼 클릭 이벤트
        btnSignin_Si.setOnClickListener {
            var str_email : String = edtEmail_Si.text.toString()
            var str_password : String = edtPassword_Si.text.toString()
            var str_repassword : String = edtRePassword_Si.text.toString()
            var str_birth : String = tvSelectBirth_Si.text.toString()
            var str_nickname : String = edtNickName_Si.text.toString()

            if ((str_email == "" )|| (str_password == "") || (str_repassword == "") || (str_birth == "") || (str_nickname == "")) {
                val dialog_empty= AlertDialog.Builder(this)
                dialog_empty.setTitle("주의")
                dialog_empty.setMessage("입력하지 않은 항목이 있습니다. \n다시 확인하세요.")
                dialog_empty.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, id -> })
                dialog_empty.show()
            }
            else {
                if (str_password.equals(str_repassword)) {

                    val dialog_confirm = AlertDialog.Builder(this)
                    dialog_confirm.setTitle("확인")
                    dialog_confirm.setMessage("입력한 사항들이 모두 맞습니까?" +
                            "\n이메일 주소 : " + str_email +
                            "\n비밀번호 : " + str_password +
                            "\n생년월일 : " + str_birth +
                            "\n닉네임 : " + str_nickname)
                    dialog_confirm.setPositiveButton("회원가입", DialogInterface.OnClickListener { dialog, id ->
                        sqlitedb = dbMemberInfo.writableDatabase
                        sqlitedb.execSQL("INSERT INTO member_info VALUES ('" +str_email+ "', '" +str_password+ "', " +str_birth+ ", '" +str_nickname+ "')")
                        sqlitedb.close()

                        var intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    })
                    dialog_confirm.setNegativeButton("다시 작성하기", DialogInterface.OnClickListener{ dialog, id ->

                    })
                    dialog_confirm.show()
                }
                else {
                    val dialog_passwordNotEqaul= AlertDialog.Builder(this)
                    dialog_passwordNotEqaul.setTitle("주의")
                    dialog_passwordNotEqaul.setMessage("입력하신 비밀번호와 재확인 비밀번호가 일치하지 않습니다.")
                    dialog_passwordNotEqaul.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, id -> })
                    dialog_passwordNotEqaul.show()
                }
            }
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