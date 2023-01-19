package com.android.tripapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var edtEmail : EditText
    lateinit var edtPassword : EditText
    lateinit var btnLogin : Button
    lateinit var btnSignin : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnSignin = findViewById(R.id.btnSignin)

    //    btnLogin.isEnabled = false

        edtPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                //텍스트를 입력 후

            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //텍스트 입력 전
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //텍스트 입력 중
                if(edtPassword.length() < 4) { // 패스워드의 길이가 4미만이면
                    btnLogin.isEnabled = false // 버튼 비활성화
                } else {
                    btnLogin.isEnabled = true // 버튼 활성화
                }
            }
        })
        // 로그인 클릭시 메인 홈 화면 액티비티로 화면 전환
        btnLogin.setOnClickListener {
            var intent = Intent(this, MainHomeActivity::class.java)
            startActivity(intent)
        }
    }
}