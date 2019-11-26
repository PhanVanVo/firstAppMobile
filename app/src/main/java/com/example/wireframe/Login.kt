package com.example.wireframe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnSingUp.setOnClickListener{
            var intent= Intent (this, home::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_botoom);
        }
        btnForgot_pass.setOnClickListener{
            var intent = Intent (this, ForgotPassword::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
        }
        btnSignup.setOnClickListener{
            var intent = Intent (this, Register::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
        }

    }
}
