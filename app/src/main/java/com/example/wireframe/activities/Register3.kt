package com.example.wireframe.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.wireframe.Model.user
import com.example.wireframe.R
import com.example.wireframe.retrofit.ApiClient
import com.example.wireframe.retrofit.ServiceBuilder
import kotlinx.android.synthetic.main.activity_register3.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Register3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register3)

        val context = this
        val Mail:String = intent.getStringExtra("email")

        val LName:String = intent.getStringExtra("LName")

        val FtName:String = intent.getStringExtra("FtName")

        btnSingUp.setOnClickListener{
            var intent= Intent (this, Login::class.java)
            var Pass:String = txtPassWord.text.toString().trim()
            var RePass:String = txtRePassWord.text.toString().trim()



            if(Pass.isEmpty() || RePass.isEmpty()){
                Toast.makeText(this,"Please enter data", Toast.LENGTH_SHORT).show()
            }else{
                if (Pass.equals(RePass,true))
                {
                    val newUser = user()
                    newUser.EMAIL = Mail
                    newUser.PASSWORD = Pass
                    newUser.FIRST_NAME = FtName
                    newUser.LAST_NAME = LName

                    val userService = ServiceBuilder.buildService(ApiClient::class.java)
                    val requestCall = userService.AddUser(newUser)

                    requestCall.enqueue(object: Callback<user> {

                        override fun onResponse(call: Call<user>, response: Response<user>) {
                            if (response.isSuccessful) {

                                var newlyCreatedDestination = response.body()
                                Log.d("Phan van vo", "${newlyCreatedDestination}")
                                //Toast.makeText(context, "Successfully Added", Toast.LENGTH_SHORT).show()
                                //startActivity(intent)

                            } else {
                                Toast.makeText(context, "Failed to add item", Toast.LENGTH_SHORT).show()
                            }
                        }
                        override fun onFailure(call: Call<user>, t: Throwable) {
                            Toast.makeText(context, "Failed to add item", Toast.LENGTH_SHORT).show()
                        }
                    })


                }
                else
                {
                    Toast.makeText(this,"false confirmacccction", Toast.LENGTH_SHORT).show()
                }

            }

        }
    }
}
