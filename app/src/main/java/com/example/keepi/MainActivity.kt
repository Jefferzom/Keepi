package com.example.keepi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
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