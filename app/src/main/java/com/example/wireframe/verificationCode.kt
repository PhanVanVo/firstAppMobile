package com.example.wireframe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_verification_code.*

class verificationCode : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification_code)
        btnSingUp.setOnClickListener{
            var intent= Intent (this, ExMenu::class.java)
            startActivity(intent)
        }
    }
}
