package com.example.keepi.service

import retrofit2.Retrofit

class RetrofitConfig {

    fun init() {
        Retrofit.Builder()
            .baseUrl("http://192.168.0.23:8080/")
    }

}