package com.example.wireframe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btnSingUp.setOnClickListener{
            var intent= Intent (this, Regiser2::class.java)
            var Ftname : String =  txtFisrtName.text.toString().trim()
            var LName : String =   txtLastName.text.toString().trim()
            intent.putExtra("Ftname", Ftname)
            intent.putExtra("LName", LName)
            startActivity(intent)
        }
    }
}
