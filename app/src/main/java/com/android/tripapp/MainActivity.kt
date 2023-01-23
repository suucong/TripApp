package com.android.tripapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(){

    lateinit var edtEmail : EditText
    lateinit var edtPassword : EditText
    lateinit var btnLogin : Button
    lateinit var btnSignin : Button
    lateinit var btnSignin2 : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnSignin = findViewById(R.id.btnSignin)
        btnSignin2 = findViewById(R.id.btnSignin2)

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
        btnLogin.setOnClickListener({
            val intent = Intent(this, NaviActivity::class.java)
            startActivity(intent)
    })
        btnSignin.setOnClickListener({
            val intent = Intent(this, Signin::class.java)
            startActivity(intent)
        })

        btnSignin2.setOnClickListener {
            var intent = Intent(this, NaviActivity::class.java)
            startActivity(intent)
        }
    }
}