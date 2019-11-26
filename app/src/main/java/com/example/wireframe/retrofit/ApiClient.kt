package com.example.wireframe.retrofit
import com.example.wireframe.Model.Post
import com.example.wireframe.Model.user
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiClient {

    @GET("register")
    fun getAllPlants() : Call<Post>

    @POST("signup")
    fun AddUser(@Body newDestination: user): Call<user>
}