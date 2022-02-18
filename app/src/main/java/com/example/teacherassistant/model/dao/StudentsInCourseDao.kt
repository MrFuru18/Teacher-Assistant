package com.example.teacherassistant.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.teacherassistant.model.entities.StudentsInCourseData

@Dao
interface StudentsInCourseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addStudentToCourse(studentInCourse: StudentsInCourseData)

    @Query("SELECT * FROM studentsInCourse_table ORDER BY idStudent ASC")
    fun readAllData(): LiveData<List<StudentsInCourseData>>

    @Query("SELECT * FROM studentsInCourse_table WHERE idCourse LIKE :searchQuery ORDER BY idStudent ASC")
    fun readStudentsInCourseData(searchQuery: String): LiveData<List<StudentsInCourseData>>

    @Query("DELETE FROM studentsInCourse_table")
    suspend fun deleteAllData()
}