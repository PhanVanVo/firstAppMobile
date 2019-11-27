package com.example.wireframe.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.wireframe.R
import kotlinx.android.synthetic.main.activity_regiser2.*

class Regiser2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regiser2)

        fun isEmailValid(email: String): Boolean {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }
        val lastName:String = intent.getStringExtra("LName")
        val firstName:String = intent.getStringExtra("FtName")
        btnSingUp.setOnClickListener{
            var intent= Intent (this, Register3::class.java)
            var Email:String = txtEmail.text.toString()

            if(isEmailValid(Email) == true)
            {
                intent.putExtra("LName", lastName)
                intent.putExtra("FtName", firstName)
                intent.putExtra("email", Email)
                startActivity(intent)
            }else{
                Toast.makeText(this,"email error", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
