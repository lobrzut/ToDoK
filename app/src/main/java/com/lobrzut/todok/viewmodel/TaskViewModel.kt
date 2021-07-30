package com.lobrzut.todok.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.lobrzut.todok.database.TaskDatabase
import com.lobrzut.todok.database.TaskEntry
import com.lobrzut.todok.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application) {

    private val taskDao = TaskDatabase.getDatabase(application).taskDao()
    private val repository : TaskRepository

    val getAllTasks: LiveData<List<TaskEntry>>


    init {
        repository = TaskRepository(taskDao)
        getAllTasks = repository.getAllTasks()


    }

/*    fun isDbEmpty(taskEntry: TaskEntry) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.isDbEmpty()
        }
    }*/

    fun insert(taskEntry: TaskEntry){
        viewModelScope.launch(Dispatchers.IO){
            repository.insert(taskEntry)
        }
    }

    fun delete(taskEntry: TaskEntry){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteItem(taskEntry)
        }
    }


    fun update(taskEntry: TaskEntry){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateData(taskEntry)
        }
    }
    /*fun deleteAll(taskEntry: TaskEntry){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAll()
        }
    }*/

}