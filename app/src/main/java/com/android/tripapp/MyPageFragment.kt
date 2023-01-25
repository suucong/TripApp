package com.android.tripapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

public class MyPageFragment : Fragment() {
    private lateinit var user: FirebaseAuth
    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        user = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance("https://tripapp-8981e-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Users")
        val view = inflater.inflate(R.layout.fragment_my_page, null)
        val toLogoutButton = view.findViewById<Button>(R.id.toLogOutButton)
        val toLoginButton = view.findViewById<Button>(R.id.toLoginButton)
        val LoginMessage = view.findViewById<TextView>(R.id.LoginMessage)

        toLogoutButton.visibility = View.INVISIBLE
        toLogoutButton.isEnabled = false

        if(user.currentUser != null) {
            user.currentUser?.let {
                LoginMessage.text = it.email
                toLoginButton.isEnabled = false
                toLoginButton.visibility = View.INVISIBLE
                toLogoutButton.isEnabled = true
                toLogoutButton.visibility = View.VISIBLE
            }
        }

        toLogoutButton.setOnClickListener {
            user.signOut()
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        toLoginButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
                activity?.finish()
            }
        })
        return view
    }
}

