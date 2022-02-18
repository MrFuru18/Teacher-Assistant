package com.example.teacherassistant.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.teacherassistant.model.AssistantDatabase
import com.example.teacherassistant.model.entities.CoursesData
import com.example.teacherassistant.model.entities.StudentsData
import com.example.teacherassistant.model.entities.StudentsInCourseData
import com.example.teacherassistant.model.repository.AssistantRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AssistantViewModel(application: Application): AndroidViewModel(application) {

    val readStudentsAllData: LiveData<List<StudentsData>>
    val readCoursesAllData: LiveData<List<CoursesData>>
    val readStudentsInCourseAllData: LiveData<List<StudentsInCourseData>>
    private val repository: AssistantRepository

    init {
        val studentsDao = AssistantDatabase.getDatabase(application).studentsDao()
        val coursesDao = AssistantDatabase.getDatabase(application).coursesDao()
        val studentsInCourseDao = AssistantDatabase.getDatabase(application).studentsInCourseDao()
        repository = AssistantRepository(studentsDao, coursesDao, studentsInCourseDao)
        readStudentsAllData = repository.readStudentsAllData
        readCoursesAllData = repository.readCoursesAllData
        readStudentsInCourseAllData = repository.readStudentsInCourseAllData
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

    fun readStudentsInCourse(searchQuery: String):  LiveData<List<StudentsInCourseData>>{
        return repository.readStudentsInCourseData(searchQuery)
    }

}