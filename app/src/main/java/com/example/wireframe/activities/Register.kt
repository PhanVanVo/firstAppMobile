package com.example.wireframe.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.wireframe.R
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnConform.setOnClickListener{

            var intent = Intent (this, Regiser2::class.java)

            var firstName:String =  txtEmail.text.toString()
            var lastName:String =  txtLastName.text.toString()
            if(firstName.isEmpty() || lastName.isEmpty()){
                Toast.makeText(this, "may not be blank", Toast.LENGTH_SHORT).show()
            }else{
                intent.putExtra("LName", lastName)
                intent.putExtra("FtName", firstName)
                startActivity(intent)
            }

        }
    }
}
