package com.android.tripapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Signin : AppCompatActivity() {
    lateinit var edtEmail_Si: EditText
    lateinit var edtPassword_Si: EditText
    lateinit var edtRePassword_Si: EditText
    lateinit var edtNickName_Si: EditText
    lateinit var btnSignin_Si: Button
    lateinit var btnBackToLogin_Si: Button

    lateinit var auth: FirebaseAuth
    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        edtEmail_Si = findViewById(R.id.edtEmail_Si)
        edtPassword_Si = findViewById(R.id.edtPassword_Si)
        edtRePassword_Si = findViewById(R.id.edtRePassword_Si)
        edtNickName_Si = findViewById(R.id.edtNickname_Si)
        btnSignin_Si = findViewById(R.id.btnSignin_Si)
        btnBackToLogin_Si = findViewById(R.id.btnBackToLogin_Si)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance("https://tripapp-8981e-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Users")

        // 회원가입 버튼 클릭 이벤트
        btnSignin_Si.setOnClickListener {
            var str_email: String = edtEmail_Si.text.toString()
            var str_password: String = edtPassword_Si.text.toString()
            var str_repassword: String = edtRePassword_Si.text.toString()
            var str_nickname: String = edtNickName_Si.text.toString()

            if ((str_email == "") || (str_password == "") || (str_repassword == "") || (str_nickname == "")) {
                val dialog_empty = AlertDialog.Builder(this)
                dialog_empty.setTitle("주의")
                dialog_empty.setMessage("입력하지 않은 항목이 있습니다. \n다시 확인하세요.")
                dialog_empty.setPositiveButton(
                    "확인",
                    DialogInterface.OnClickListener { dialog, id -> })
                dialog_empty.show()
            } else {
                if (str_password.equals(str_repassword)) {

                    val dialog_confirm = AlertDialog.Builder(this)
                    dialog_confirm.setTitle("확인")
                    dialog_confirm.setMessage(
                        "입력한 사항들이 모두 맞습니까?" +
                                "\n이메일 주소 : " + str_email +
                                "\n비밀번호 : " + str_password +
                                "\n닉네임 : " + str_nickname
                    )
                    dialog_confirm.setPositiveButton(
                        "회원가입",
                        DialogInterface.OnClickListener { dialog, id ->
                            auth.createUserWithEmailAndPassword(str_email, str_repassword)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        var intent = Intent(this, NaviActivity::class.java)
                                        startActivity(intent)
                                        val User = User(str_email, str_repassword, str_nickname)
                                        database.child(str_nickname).setValue(User)
                                        Toast.makeText(this, "회원가입에 성공했습니다!", Toast.LENGTH_SHORT)
                                            .show()
                                    } else {
                                        Toast.makeText(
                                            this,
                                            "이미 존재하는 계정입니다. 회원가입에 실패했습니다.",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                        })
                    dialog_confirm.setNegativeButton(
                        "다시 작성하기",
                        DialogInterface.OnClickListener { dialog, id ->
                        })
                    dialog_confirm.show()
                } else {
                    val dialog_passwordNotEqaul = AlertDialog.Builder(this)
                    dialog_passwordNotEqaul.setTitle("주의")
                    dialog_passwordNotEqaul.setMessage("입력하신 비밀번호와 재확인 비밀번호가 일치하지 않습니다.")
                    dialog_passwordNotEqaul.setPositiveButton(
                        "확인",
                        DialogInterface.OnClickListener { dialog, id -> })
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
}




