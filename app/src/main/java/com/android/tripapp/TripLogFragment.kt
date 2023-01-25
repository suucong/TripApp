package com.android.tripapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class TripLogFragment : Fragment() {
    private lateinit var user: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        user = FirebaseAuth.getInstance()
        val view = inflater.inflate(R.layout.fragment_trip_log, null)
        val LoginMessage_ = view.findViewById<TextView>(R.id.LoginMessage_)
        val AddTripLogButton = view.findViewById<ImageButton>(R.id.AddTripLogButton)

        if(user.currentUser != null) {
            user.currentUser?.let {
                LoginMessage_.text = it.email
            }
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            TripLogFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}