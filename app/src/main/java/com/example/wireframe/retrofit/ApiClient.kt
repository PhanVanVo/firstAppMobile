package com.example.wireframe.retrofit
import com.example.wireframe.Model.*
import retrofit2.Call
import retrofit2.http.*


interface ApiClient {


    @POST("signup")
    fun AddUser(@Body newDestination: user): Call<signup>

    @POST("login")
    fun Login(@Body newlogin: login): Call<signin>

//    @GET("profile")
//    fun profile(@Header("Authorization")String: signin): Call<proFile>

    @POST("forgot")
    fun forgot(@Body forgotPassWord: forgotPass): Call<forgotPass>

    @GET("forgot/{id}")
    fun getforgotPass(@Path("id") id: Int): Call<forgotPass>

    @FormUrlEncoded
    @PUT("forgot/{email}")
    fun changePass(@Path("email") mail: String, @Field("password") passs: String): Call<forgotPass>
}