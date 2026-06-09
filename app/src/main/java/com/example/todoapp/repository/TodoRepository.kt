package com.example.todoapp.repository

import com.example.todoapp.data.TodoDao
import com.example.todoapp.data.TodoEntity

class TodoRepository(
    private val todoDao: TodoDao
) {

    fun getAllTodos() = todoDao.getAllTodos()

    suspend fun insertTodo(todo: TodoEntity) {
        todoDao.insertTodo(todo)
    }

    suspend fun updateTodo(todo: TodoEntity) {
        todoDao.updateTodo(todo)
    }

    suspend fun deleteTodo(todo: TodoEntity) {
        todoDao.deleteTodo(todo)
    }
}