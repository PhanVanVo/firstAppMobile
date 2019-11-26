package com.example.wireframe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class ForgotPassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        btnSingUp.setOnClickListener{
            var intent= Intent (this, verificationCode::class.java)
            startActivity(intent)
        }
    }
}
