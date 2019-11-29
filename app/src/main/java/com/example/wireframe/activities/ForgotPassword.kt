package com.example.wireframe.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.wireframe.Model.forgotPass
import com.example.wireframe.Model.signup
import com.example.wireframe.R
import com.example.wireframe.retrofit.ApiClient
import com.example.wireframe.retrofit.ServiceBuilder
import kotlinx.android.synthetic.main.activity_forgot_password.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgotPassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val context = this

        btnConform.setOnClickListener{
            var intent= Intent (this, verificationCode::class.java)
            val forGotService = ServiceBuilder.buildService(ApiClient::class.java)

            var Email:String = txtEmail.text.toString().trim()

            val forPass = forgotPass()
            forPass.Status = ""
            forPass.Message = ""
            forPass.OTP = ""
            forPass.EMAIL = Email

            val requestCall = forGotService.forgot(forPass)


            requestCall.enqueue(object: Callback<forgotPass> {

                override fun onResponse(call: Call<forgotPass>, response: Response<forgotPass>) {
                    if (response.isSuccessful) {
                        if(response.body()?.Status == "0")
                        {
                            intent.putExtra("Email", Email)
                            Toast.makeText(context, response.body()?.OTP, Toast.LENGTH_SHORT).show()
                            startActivity(intent)
                        }else if(response.body()?.Status == "10"){
                            Toast.makeText(context, "Mail does not exist", Toast.LENGTH_SHORT).show()
                        }

                    }else {
                        Toast.makeText(context, "system error", Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<forgotPass>, t: Throwable) {
                    Toast.makeText(context, "system error", Toast.LENGTH_SHORT).show()
                }
            })

        }
    }
}
