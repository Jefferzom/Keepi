package com.example.keepi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.keepi.model.Note
import com.example.keepi.retrofit.RetrofitConfig
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        val call = RetrofitConfig().noteService().list()
        call.enqueue(object: Callback<List<Note>?> {
            override fun onResponse(call: Call<List<Note>?>?,
                                    response: Response<List<Note>?>?) {

                response?.body()?.let {
                    val notes: List<Note> = it
                    configureList(notes)
                }

            }

            override fun onFailure(call: Call<List<Note>?>?,
                                   t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })

         fun configureList(notes: List<Note>) {
            val recyclerView = findViewById<RecyclerView>(R.id.note_list_recyclerView)
            recyclerView.adapter = NoteListAdapter(notes(), this)
            val layoutManager = StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL)
            recyclerView.layoutManager = layoutManager
        }
    }

    private fun notes(): List<Note> {
        return listOf(
            Note("Leitura",
            "Livro de Kotlin com Android"
                ),
            Note("Javascript & Jquery",
                "Aprendendo JS e Jquery"
                ),
            Note("Pai Rico pai pobre",
            "Entenda a vida de quem sabe economizar")
        )
    }
}