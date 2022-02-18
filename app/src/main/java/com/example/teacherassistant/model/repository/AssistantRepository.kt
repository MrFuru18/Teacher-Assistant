package com.example.teacherassistant.model.repository

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.example.teacherassistant.model.dao.CoursesDao
import com.example.teacherassistant.model.dao.GradesDao
import com.example.teacherassistant.model.dao.StudentsDao
import com.example.teacherassistant.model.dao.StudentsInCourseDao
import com.example.teacherassistant.model.entities.CoursesData
import com.example.teacherassistant.model.entities.GradesData
import com.example.teacherassistant.model.entities.StudentsData
import com.example.teacherassistant.model.entities.StudentsInCourseData

class AssistantRepository(private val studentsDao: StudentsDao, private val coursesDao: CoursesDao, private val studentsInCourseDao: StudentsInCourseDao, private val gradesDao: GradesDao) {

    val readStudentsAllData: LiveData<List<StudentsData>> = studentsDao.readAllData()
    val readCoursesAllData: LiveData<List<CoursesData>> = coursesDao.readAllData()
    val readStudentsInCourseAllData: LiveData<List<StudentsInCourseData>> = studentsInCourseDao.readAllData()
    val readGradesAllData: LiveData<List<GradesData>> = gradesDao.readAllData()

    suspend fun addStudent(student: StudentsData){
        studentsDao.addStudent(student)
    }

    suspend fun addCourse(course: CoursesData){
        coursesDao.addCourse(course)
    }

    suspend fun addStudentToCourse(studentInCourse: StudentsInCourseData){
        studentsInCourseDao.addStudentToCourse(studentInCourse)
    }

    suspend fun addGrades(grade: GradesData){
        gradesDao.addGrade(grade)
    }

    suspend fun updateGrade(grade: GradesData){
        gradesDao.updateGrade(grade)
    }

    fun readStudentsInCourseData(searchQuery: String):  LiveData<List<StudentsInCourseData>>{
        return studentsInCourseDao.readStudentsInCourseData(searchQuery)
    }

    fun readGrades(searchQuery: String, searchQuery2: String):  LiveData<List<GradesData>>{
        return gradesDao.readGrades(searchQuery, searchQuery2)
    }

    suspend fun deleteAllStudents(){
        studentsDao.deleteAllData()
    }

    suspend fun deleteAllCourses(){
        coursesDao.deleteAllData()
    }

    suspend fun deleteAllStudentsInCourses(){
        studentsInCourseDao.deleteAllData()
    }

    suspend fun deleteAllGrades(){
        gradesDao.deleteAllData()
    }

}