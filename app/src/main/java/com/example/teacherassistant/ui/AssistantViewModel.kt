package com.example.teacherassistant.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.teacherassistant.model.AssistantDatabase
import com.example.teacherassistant.model.entities.CoursesData
import com.example.teacherassistant.model.entities.GradesData
import com.example.teacherassistant.model.entities.StudentsData
import com.example.teacherassistant.model.entities.StudentsInCourseData
import com.example.teacherassistant.model.repository.AssistantRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AssistantViewModel(application: Application): AndroidViewModel(application) {

    val readStudentsAllData: LiveData<List<StudentsData>>
    val readCoursesAllData: LiveData<List<CoursesData>>
    val readStudentsInCourseAllData: LiveData<List<StudentsInCourseData>>
    val readGradesAllData: LiveData<List<GradesData>>
    private val repository: AssistantRepository

    init {
        val studentsDao = AssistantDatabase.getDatabase(application).studentsDao()
        val coursesDao = AssistantDatabase.getDatabase(application).coursesDao()
        val studentsInCourseDao = AssistantDatabase.getDatabase(application).studentsInCourseDao()
        val gradesDao = AssistantDatabase.getDatabase(application).gradesDao()
        repository = AssistantRepository(studentsDao, coursesDao, studentsInCourseDao, gradesDao)
        readStudentsAllData = repository.readStudentsAllData
        readCoursesAllData = repository.readCoursesAllData
        readStudentsInCourseAllData = repository.readStudentsInCourseAllData
        readGradesAllData = repository.readGradesAllData
    }

    fun addStudent(student: StudentsData){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addStudent(student)
        }
    }

    fun addCourse(course: CoursesData){
        viewModelScope.launch(Dispatchers.IO){
            repository.addCourse(course)
        }
    }

    fun addStudentToCourse(studentInCourse: StudentsInCourseData){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addStudentToCourse(studentInCourse)
        }
    }

    fun addGrade(grade: GradesData){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addGrades(grade)
        }
    }

    fun readStudentsInCourse(searchQuery: String):  LiveData<List<StudentsInCourseData>>{
        return repository.readStudentsInCourseData(searchQuery)
    }

    fun readGrades(searchQuery: String, searchQuery2: String):  LiveData<List<GradesData>>{
        return repository.readGrades(searchQuery, searchQuery2)
    }

    fun deleteStudents(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllStudents()
        }
    }

    fun deleteCourses(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllCourses()
        }
    }

    fun deleteStudentsInCourses(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllStudentsInCourses()
        }
    }

    fun deleteGrades(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllGrades()
        }
    }
}