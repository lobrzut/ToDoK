package com.lobrzut.todok.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
abstract class TaskDao {

    //abstract!!

    @Insert
    abstract suspend fun insert(taskEntry: TaskEntry)

    @Delete
    abstract suspend fun delete(taskEntry: TaskEntry)

    @Update
    abstract suspend fun update(taskEntry: TaskEntry)

    @Query("DELETE FROM task_table")
    abstract suspend fun deleteAll()

    @Query("SELECT * FROM task_table ORDER BY timestamp DESC")
    abstract fun getAllTasks():LiveData<List<TaskEntry>>
}