package com.example.teacherassistant.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.teacherassistant.model.entities.CoursesData

@Dao
interface CoursesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCourse(course: CoursesData)

    @Query("SELECT * FROM courses_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<CoursesData>>
}