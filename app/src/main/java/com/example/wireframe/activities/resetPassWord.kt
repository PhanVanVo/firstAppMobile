package com.example.wireframe.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.wireframe.Model.forgotPass
import com.example.wireframe.R
import com.example.wireframe.retrofit.ApiClient
import com.example.wireframe.retrofit.ServiceBuilder
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btnConform
import kotlinx.android.synthetic.main.activity_login.txtEmail
import kotlinx.android.synthetic.main.activity_login.txtPassWord
import kotlinx.android.synthetic.main.activity_reset_pass_word.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class resetPassWord : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_pass_word)
        val context = this
        val Email:String = intent.getStringExtra("Email")
        btnConform.setOnClickListener{
            var intent= Intent (this, Login::class.java)
            var Pass:String = txtPassWord.text.toString().trim()
            var RePass:String = txtRePassWord.text.toString().trim()

            if(Pass.isEmpty() || RePass.isEmpty() )
            {

                Toast.makeText(this, "may not be empty", Toast.LENGTH_SHORT).show()
            }else if(Pass.equals(RePass,true))
            {
                Toast.makeText(this, "enter password", Toast.LENGTH_SHORT).show()
                val forGotService = ServiceBuilder.buildService(ApiClient::class.java)

                val requestCall = forGotService.changePass(Email,Pass)
                requestCall.enqueue(object: Callback<forgotPass> {

                    override fun onResponse(call: Call<forgotPass>, response: Response<forgotPass>) {
                        if (response.isSuccessful) {
                            if(response.body()?.Status == "0")
                            {

                                Toast.makeText(context, "successfully", Toast.LENGTH_SHORT).show()
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


            }else{

                Toast.makeText(this, "false confirmacccction", Toast.LENGTH_SHORT).show()

            }

        }
    }
}
