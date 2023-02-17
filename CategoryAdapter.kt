package com.example.todolist.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.data.model.CategoryName
import com.example.todolist.ui.HomeFragmentDirections

class CategoryAdapter (): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var dataset = listOf<CategoryName>()

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
            val name: TextView = view.findViewById(R.id.category_text)
            val card: CardView = view.findViewById(R.id.detail_click_card)



    }

    fun submitList(list: List<CategoryName>){

        dataset = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ViewHolder(adapterLayout)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categorys = dataset[position]

        holder.name.text = categorys.name


        holder.card.setOnClickListener {

            Log.d("Id", categorys.id.toString())

            holder.itemView.findNavController()
                .navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(categorys.id))
        }



    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}