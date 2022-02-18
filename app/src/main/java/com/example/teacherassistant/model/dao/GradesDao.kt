package com.example.teacherassistant.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.teacherassistant.model.entities.GradesData

@Dao
interface GradesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addGrade(grade: GradesData)

    @Query("SELECT * FROM grades_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<GradesData>>

    @Query("SELECT * FROM grades_table WHERE idCourse LIKE :searchQuery AND idStudent LIKE :searchQuery2 ORDER BY idStudent ASC")
    fun readGrades(searchQuery: String, searchQuery2: String): LiveData<List<GradesData>>

    @Query("DELETE FROM grades_table")
    suspend fun deleteAllData()
}