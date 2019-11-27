package com.example.wireframe.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.wireframe.R
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnSingUp.setOnClickListener{

            var intent = Intent (this, Regiser2::class.java)
            var firstName:String =  txtFisrtName.text.toString()
            var lastName:String =  txtLastName.text.toString()

            intent.putExtra("LName", lastName)
            intent.putExtra("FtName", firstName)
            startActivity(intent)
        }
    }
}
