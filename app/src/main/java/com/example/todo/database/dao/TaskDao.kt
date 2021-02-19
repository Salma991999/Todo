package com.example.todo.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todo.database.model.Task

interface TaskDao {
    @Insert
    fun addTask(task: Task)
    @Update
    fun updateTask(task: Task)
    @Delete
    fun deleteTask(task: Task)
    @Query("select * from Task ")
    fun getAllTask():List<Task>
    @Query("select * from Task where title like :word or description like :word ")
    fun searchForTask(word:String):List<Task>
}

