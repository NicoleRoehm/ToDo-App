package com.example.todolist.data

import com.example.todolist.data.model.CategoryName

class Repository {

    fun loadCategory():List<CategoryName>{
        return listOf(

            CategoryName(
                0,
                "School-Don",
                mutableListOf()
            ),
            CategoryName(
                1,
                "Purchasing",
                mutableListOf()
            ),
            CategoryName(
                2,
                "bills",
                mutableListOf()
            ),
            CategoryName(
                3,
                "Household",
                mutableListOf()
            ),
            CategoryName(
                4,
                "offices",
                mutableListOf()
            ),
            CategoryName(
                5,
                "Work",
                mutableListOf()
            ),
            CategoryName(
                6,
                "Kita",
                mutableListOf()
            ),
            CategoryName(
                7,
                "Holidays",
                mutableListOf()
            ),
            CategoryName(
                8,
                "vatication planning",
                mutableListOf()
            ),
        )
    }
}