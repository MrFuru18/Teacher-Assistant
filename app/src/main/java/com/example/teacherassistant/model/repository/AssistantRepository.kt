package com.example.teacherassistant.model.repository

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.example.teacherassistant.model.dao.CoursesDao
import com.example.teacherassistant.model.dao.StudentsDao
import com.example.teacherassistant.model.dao.StudentsInCourseDao
import com.example.teacherassistant.model.entities.CoursesData
import com.example.teacherassistant.model.entities.StudentsData
import com.example.teacherassistant.model.entities.StudentsInCourseData

class AssistantRepository(private val studentsDao: StudentsDao, private val coursesDao: CoursesDao, private val studentsInCourseDao: StudentsInCourseDao) {

    val readStudentsAllData: LiveData<List<StudentsData>> = studentsDao.readAllData()
    val readCoursesAllData: LiveData<List<CoursesData>> = coursesDao.readAllData()
    val readStudentsInCourseAllData: LiveData<List<StudentsInCourseData>> = studentsInCourseDao.readAllData()

    suspend fun addStudent(student: StudentsData){
        studentsDao.addStudent(student)
    }

    suspend fun addCourse(course: CoursesData){
        coursesDao.addCourse(course)
    }

    suspend fun addStudentToCourse(studentInCourse: StudentsInCourseData){
        studentsInCourseDao.addStudentToCourse(studentInCourse)
    }

    fun readStudentsInCourseData(searchQuery: String):  LiveData<List<StudentsInCourseData>>{
        return studentsInCourseDao.readStudentsInCourseData(searchQuery)
    }

}