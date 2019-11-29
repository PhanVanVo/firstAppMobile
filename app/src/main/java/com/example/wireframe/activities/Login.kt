package com.example.wireframe.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.wireframe.Model.login
import com.example.wireframe.Model.signin
import com.example.wireframe.R
import com.example.wireframe.retrofit.ApiClient
import com.example.wireframe.retrofit.ServiceBuilder
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        fun isEmailValid(email: String): Boolean {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        btnConform.setOnClickListener{
            var intent= Intent (this, home::class.java)
            val context = this
            val newlogin = login()
            newlogin.login_ID = txtEmail.text.toString()
            newlogin.passwd_TXT = txtPassWord.text.toString()
            if(isEmailValid(newlogin.login_ID) == true){
                val destinationService = ServiceBuilder.buildService(ApiClient::class.java)
                val requestCall = destinationService.Login(newlogin)

                requestCall.enqueue(object: Callback<signin> {

                    override fun onResponse(call: Call<signin>, response: Response<signin>) {
                        if (response.isSuccessful) {

                            if(response.body()?.status == "0"){

                                startActivity(intent)
                                overridePendingTransition(
                                    R.anim.slide_in_bottom,
                                    R.anim.slide_out_botoom
                                )

                            }else if(response.body()?.status == "1"){
                                Toast.makeText(context, "Please check your username or password", Toast.LENGTH_SHORT).show()
                            }else{
                                Toast.makeText(context, "Password wrong", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(context, "system error", Toast.LENGTH_SHORT).show()
                        }
                    }
                    override fun onFailure(call: Call<signin>, t: Throwable) {
                        Toast.makeText(context, "system error", Toast.LENGTH_SHORT).show()
                    }
                })
            }else{
                Toast.makeText(context, "Mail wrong", Toast.LENGTH_SHORT).show()
            }








        }
        btnForgot_pass.setOnClickListener{
            var intent = Intent (this, ForgotPassword::class.java)
            startActivity(intent)
            overridePendingTransition(
                R.anim.slide_in_bottom,
                R.anim.slide_out_top
            );
        }
        btnSignup.setOnClickListener{
            var intent = Intent (this, Register::class.java)
            startActivity(intent)
            overridePendingTransition(
                R.anim.slide_in_bottom,
                R.anim.slide_out_top
            );
        }

    }
}
