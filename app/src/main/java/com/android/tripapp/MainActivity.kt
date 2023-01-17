package com.android.tripapp

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        btnLogin.setClickable(false)

        if (edtEmail.text != null && edtPassword.text != null) {
            btnLogin.setClickable(true)
            //btnLogin.setBackgroundColor(Color.parseColor("#FF6700F9"))
        }




    }
}