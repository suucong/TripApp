package com.android.tripapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Signin : AppCompatActivity() {

    lateinit var edtPasswordSi : EditText
    lateinit var edtRePasswordSi : EditText
    lateinit var btnBackToLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        edtPasswordSi = findViewById(R.id.edtRePasswordSi)
        edtRePasswordSi = findViewById(R.id.edtRePasswordSi)
        btnBackToLogin = findViewById(R.id.btnBackToLogin)

        btnBackToLogin.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}