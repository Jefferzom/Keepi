package com.example.keepi.retrofit

import com.example.keepi.retrofit.service.NoteService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {

    fun init() {
        Retrofit.Builder()
            .baseUrl("http://192.168.0.23:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun noteService(): NoteService = retrofit.create(NoteService::class.java)

}