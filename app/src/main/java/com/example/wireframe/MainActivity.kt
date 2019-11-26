package com.example.wireframe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.wireframe.Model.Post
import kotlinx.android.synthetic.main.activity_main.*
import com.example.wireframe.retrofit.IMyAPI
import com.example.wireframe.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback <Post>{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       var apiClient =  IMyAPI.clientHomePage?.create(ApiClient::class.java)?.getAllPlants()
        apiClient?.enqueue(this)

        btnNext.setOnClickListener{
            var intent= Intent (this, Login::class.java)
            startActivity(intent)
        }


    }

    override fun onFailure(call: Call<Post>?, t: Throwable?) {

    }

    override fun onResponse(call: Call<Post>?, post: Response<Post>?) {
        //Log.d("Kiemttra", "${post?.body()?.avatarUrl}")
    }

}
