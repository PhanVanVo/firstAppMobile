package com.example.wireframe.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.wireframe.Model.forgotPass
import com.example.wireframe.R
import com.example.wireframe.retrofit.ApiClient
import com.example.wireframe.retrofit.ServiceBuilder
import kotlinx.android.synthetic.main.activity_verification_code.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class verificationCode : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification_code)
        val context = this
        val Email:String = intent.getStringExtra("Email")
        btnConform.setOnClickListener{

            var intent= Intent (this, resetPassWord::class.java)
            var firstNumber:String =txtfirstNumber.text.toString()
            var secondNumber:String =txtsecondNumber.text.toString()
            var thirdNumber:String =txtthirdNumber.text.toString()
            var fourthNumber:String =txtfourthNumber.text.toString()

            if(firstNumber.isEmpty() || secondNumber.isEmpty() || thirdNumber.isEmpty() || fourthNumber.isEmpty())
            {
                Toast.makeText(this, "may not be empty", Toast.LENGTH_SHORT).show()
            }else{
                var ficationCode:String = firstNumber + secondNumber + thirdNumber + fourthNumber
                var verificationCode:Int = ficationCode.toInt()
                val forGotService = ServiceBuilder.buildService(ApiClient::class.java)
                val requestCall = forGotService.getforgotPass(verificationCode)

                requestCall.enqueue(object: Callback<forgotPass> {

                    override fun onResponse(call: Call<forgotPass>, response: Response<forgotPass>) {
                        if (response.isSuccessful) {
                            if(response.body()?.Status == "0")
                            {
                                intent.putExtra("Email", Email)
                                Toast.makeText(context, "Enter your new password", Toast.LENGTH_SHORT).show()
                                startActivity(intent)
                            }else if(response.body()?.Status == "10"){
                                Toast.makeText(context, "verificationCode wrong", Toast.LENGTH_SHORT).show()
                                txtfirstNumber.setText("")
                                txtsecondNumber.setText("")
                                txtthirdNumber.setText("")
                                txtfourthNumber.setText("")

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
}
