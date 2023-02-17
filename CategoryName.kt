package com.example.todolist.data.model

data class CategoryName(

    val id: Int,
    val name: String,
    val historyToDos: MutableList<String>
)
