package com.example.wireframe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_wellcome3.*

class wellcome3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wellcome3)

        btnEnd.setOnClickListener{
            var intent= Intent (this, Login::class.java)
            startActivity(intent)
        }
    }
}
