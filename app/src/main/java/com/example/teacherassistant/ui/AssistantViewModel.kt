package com.example.teacherassistant.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.teacherassistant.model.AssistantDatabase
import com.example.teacherassistant.model.entities.CoursesData
import com.example.teacherassistant.model.entities.StudentsData
import com.example.teacherassistant.model.repository.AssistantRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AssistantViewModel(application: Application): AndroidViewModel(application) {

    val readStudentsAllData: LiveData<List<StudentsData>>
    val readCoursesAllData: LiveData<List<CoursesData>>
    private val repository: AssistantRepository

    init {
        val studentsDao = AssistantDatabase.getDatabase(application).studentsDao()
        val coursesDao = AssistantDatabase.getDatabase(application).coursesDao()
        repository = AssistantRepository(studentsDao, coursesDao)
        readStudentsAllData = repository.readStudentsAllData
        readCoursesAllData = repository.readCoursesAllData
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

}