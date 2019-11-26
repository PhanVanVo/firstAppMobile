package com.example.wireframe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_regiser2.*

class Regiser2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regiser2)

        fun isEmailValid(email: String): Boolean {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }


        btnSingUp.setOnClickListener{
            var intent= Intent (this, Register3::class.java)
            var Email:String = txtEmail.text.toString()

            if(isEmailValid(Email) == true)
            {
                intent.putExtra("email", Email)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Error mail", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
