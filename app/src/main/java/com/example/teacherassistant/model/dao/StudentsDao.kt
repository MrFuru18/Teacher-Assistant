package com.example.teacherassistant.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.teacherassistant.model.entities.StudentsData

@Dao
interface StudentsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addStudent(student: StudentsData)

    @Query("SELECT * FROM students_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<StudentsData>>

    @Query("DELETE FROM students_table")
    suspend fun deleteAllData()
}