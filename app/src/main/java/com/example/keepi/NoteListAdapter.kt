package com.example.keepi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.keepi.model.Note


class NoteListAdapter(private val notes: List<Note>,
                      private val context: Context ) : Adapter<NoteListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(note: Note) {
            val title = itemView.findViewById<TextView>(R.id.note_item_title)
            val description = itemView.findViewById<TextView>(R.id.note_item_description)

            title.text = note.title
            description.text = note.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.note_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder?.let {
            it.bindView(note)
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

}
