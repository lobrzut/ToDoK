package com.lobrzut.todok.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {

    @Insert
    fun insert(taskEntry: TaskEntry)

    @Delete
    fun delete(taskEntry: TaskEntry)

    @Update
    fun update(taskEntry: TaskEntry)

    /*@Query("DELETE FROM task_table")
    fun deleteAll()*/

    @Query("SELECT * FROM task_table ORDER BY timestamp DESC")
    fun getAllTasks(): LiveData<List<TaskEntry>>







}

