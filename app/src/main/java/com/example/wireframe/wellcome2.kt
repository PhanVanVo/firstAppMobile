package com.example.wireframe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_wellcome2.*

class wellcome2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wellcome2)
        btnNext.setOnClickListener{
            var intent= Intent (this, wellcome3::class.java)
            startActivity(intent)
        }
    }
}
