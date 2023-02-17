package com.example.todolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.data.Repository
import com.example.todolist.data.model.CategoryName

class MainViewModel : ViewModel() {

    private val repository = Repository()

    private val _category = MutableLiveData<List<CategoryName>>()
    val category: LiveData<List<CategoryName>>
    get() = _category

    private val _toDoList = MutableLiveData<MutableList<String>>()
    val toDoList : LiveData<MutableList<String>>
    get()= _toDoList

    fun loadToDos(id:Int){

        val todos = _category.value?.find { it.id == id }
        if (todos != null){
            _toDoList.value = todos.historyToDos
        }
    }

    fun addToDos(todos:String){
        _toDoList.value?.add(0,todos)
        _toDoList.value = _toDoList.value
    }
    init {
        _category.value = repository.loadCategory()
    }
}