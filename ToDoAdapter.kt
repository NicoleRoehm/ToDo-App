package com.example.todolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R

class ToDoAdapter (): RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {

    private var dataset = listOf<String>()

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val todoText = view.findViewById<TextView>(R.id.todo_text)


    }

    fun submitList(list: List<String>){
        dataset = list
        notifyItemInserted(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_item, parent, false)

        return ViewHolder(adapterLayout)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val toDos = dataset[position]

        holder.todoText.text = toDos

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}