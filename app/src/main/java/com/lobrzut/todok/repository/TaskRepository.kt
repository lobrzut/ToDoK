package com.lobrzut.todok.repository

import androidx.lifecycle.LiveData
import com.lobrzut.todok.database.TaskDao
import com.lobrzut.todok.database.TaskEntry


class TaskRepository(val taskDao: TaskDao) {

    suspend fun insert(taskEntry: TaskEntry) =  taskDao.insert(taskEntry)
    suspend fun updateData(taskEntry: TaskEntry)=taskDao.update(taskEntry)
    suspend fun deleteItem(taskEntry: TaskEntry)=taskDao.delete(taskEntry)

    suspend fun delteAll() {
        taskDao.deleteAll()
    }
    fun  getAllTasks(): LiveData<List<TaskEntry>> = taskDao.getAllTasks()
}