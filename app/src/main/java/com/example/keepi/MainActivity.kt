package com.example.keepi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.keepi.model.Note

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        val recyclerView = findViewById<RecyclerView>(R.id.note_list_recyclerView)
        recyclerView.adapter = NoteListAdapter(notes(), this)
        val layoutManager = StaggeredGridLayoutManager(
            2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
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