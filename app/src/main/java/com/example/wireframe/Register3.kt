package com.example.wireframe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.wireframe.Model.user
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
        btnSingUp.setOnClickListener{
            var intent= Intent (this, Login::class.java)
            var Pass:String = txtPassWord.text.toString().trim()
            var RePass:String = txtRePassWord.text.toString().trim()


            if(Pass.isEmpty() || RePass.isEmpty()){
                Toast.makeText(this,"Please enter data", Toast.LENGTH_SHORT).show()
            }else{
                if (Pass.equals(RePass,true))
                {
                    val Mail:String = intent.getStringExtra("email")
                    val FtName:String = intent.getStringExtra("Ftname")
                    val LName:String = intent.getStringExtra("LName")

                    Log.d("pppppppppp", "${Mail}")
                    val newUser = user()
                    newUser.email = Mail
                    newUser.password = Pass
                    newUser.firstName = FtName
                    newUser.lastName = LName
                    //startActivity(intent)


                    val destinationService = ServiceBuilder.buildService(ApiClient::class.java)
                    val requestCall = destinationService.AddUser(newUser)

                    requestCall.enqueue(object: Callback<user> {

                        override fun onResponse(call: Call<user>, response: Response<user>) {
                            if (response.isSuccessful) {
                                finish() // Move back to DestinationListActivity

                                var newlyCreatedDestination = response.body() // Use it or ignore it
                                //Toast.makeText(this, "Successfully Added", Toast.LENGTH_SHORT).show()
                            } else {
                                //Toast.makeText(this, "Failed to add item", Toast.LENGTH_SHORT).show()
                            }
                        }

                        override fun onFailure(call: Call<user>, t: Throwable) {
                            //Toast.makeText(this, "Failed to add item", Toast.LENGTH_SHORT).show()
                        }
                    })
                }
                else
                {
                    Toast.makeText(this,"false confirmation", Toast.LENGTH_SHORT).show()
                }

            }

        }
    }
}
