package com.example.wireframe.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class signup {
    @SerializedName("Status")
    @Expose
    var status: String? = null
    @SerializedName("Message")
    @Expose
    var message: String? = null
}