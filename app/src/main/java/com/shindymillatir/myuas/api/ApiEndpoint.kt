package com.shindymillatir.myuas.api

import com.shindymillatir.myuas.Model.Model
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("data.php")
    fun data() : Call<Model>
}