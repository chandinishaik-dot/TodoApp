package com.example.todoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.TodoEntity
import com.example.todoapp.repository.TodoRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TodoViewModel(
    private val repository: TodoRepository
) : ViewModel() {

    val todos = repository
        .getAllTodos()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun addTodo(title: String) {
        viewModelScope.launch {
            repository.insertTodo(
                TodoEntity(
                    todoTitle = title
                )
            )
        }
    }

    fun updateTodo(todo: TodoEntity) {
        viewModelScope.launch {
            repository.updateTodo(todo)
        }
    }

    fun deleteTodo(todo: TodoEntity) {
        viewModelScope.launch {
            repository.deleteTodo(todo)
        }
    }
    fun updateTodoCompletion(
        todo: TodoEntity,
        isCompleted: Boolean
    ) {
        viewModelScope.launch {
            repository.updateTodo(
                todo.copy(
                    isCompleted = isCompleted
                )
            )
        }
    }
}