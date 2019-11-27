package com.example.wireframe.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wireframe.R
import kotlinx.android.synthetic.main.activity_ex_menu.*

class ExMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex_menu)
        btnSingUp.setOnClickListener{
            var intent= Intent (this, home::class.java)
            startActivity(intent)
            overridePendingTransition(
                R.anim.slide_in_bottom,
                R.anim.slide_out_botoom
            );
        }
    }
}
