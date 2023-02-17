package com.example.todolist.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.todolist.MainViewModel
import com.example.todolist.adapter.ToDoAdapter
import com.example.todolist.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel:MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //Todo code

        val categoryId = requireArguments().getInt("categoryId")

        viewModel.loadToDos(categoryId)

        val toDoAdapter = ToDoAdapter()
        binding.detailRecyclerView.adapter = toDoAdapter

        viewModel.category.observe(viewLifecycleOwner){ list->

            val toDos = list.find { it.id == categoryId }

            Log.d("id2", categoryId.toString())
            if (toDos != null){
                binding.detailMaterialtoolbar.setTitle(toDos.name)
            }

        }
        viewModel.toDoList.observe(viewLifecycleOwner){
            toDoAdapter.submitList(it)

            binding.detailSendButton2.setOnClickListener{
                var isEmpty = true
                for(char in binding.detailInputLayoutText.text.toString()){
                    isEmpty = false
                }
                if(!isEmpty){
                    val newTodos = binding.detailInputLayoutText.text.toString()

                    viewModel.addToDos(newTodos)
                    binding.detailInputLayoutText.setText("")
                }
            }
        }

    }

}