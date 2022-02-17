package com.example.teacherassistant.model.repository

import androidx.lifecycle.LiveData
import com.example.teacherassistant.model.dao.CoursesDao
import com.example.teacherassistant.model.dao.StudentsDao
import com.example.teacherassistant.model.entities.CoursesData
import com.example.teacherassistant.model.entities.StudentsData

class AssistantRepository(private val studentsDao: StudentsDao, private val coursesDao: CoursesDao) {

    val readStudentsAllData: LiveData<List<StudentsData>> = studentsDao.readAllData()
    val readCoursesAllData: LiveData<List<CoursesData>> = coursesDao.readAllData()

    suspend fun addStudent(student: StudentsData){
        studentsDao.addStudent(student)
    }

    suspend fun addCourse(course: CoursesData){
        coursesDao.addCourse(course)
    }

}