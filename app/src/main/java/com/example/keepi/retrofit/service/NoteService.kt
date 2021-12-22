package com.example.keepi.retrofit.service

import com.example.keepi.model.Note
import retrofit2.Call
import retrofit2.http.GET

interface NoteService {
    @GET("notes")
    fun list() : Call<List<Note>>
}