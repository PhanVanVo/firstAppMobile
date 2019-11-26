package com.example.wireframe.retrofit

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class IMyAPI: Application(){
    companion object{
        var clientHomePage:Retrofit? = null

    }

    override fun onCreate() {
        super.onCreate()
        clientHomePage = Retrofit.Builder().baseUrl("http://192.168.107.231:8085/seller/").addConverterFactory(GsonConverterFactory.create()).build()
    }

}