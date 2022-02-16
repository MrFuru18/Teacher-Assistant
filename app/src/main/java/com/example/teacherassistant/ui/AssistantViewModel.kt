package com.example.teacherassistant.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.teacherassistant.model.AssistantDatabase
import com.example.teacherassistant.model.entities.StudentsData
import com.example.teacherassistant.model.repository.AssistantRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AssistantViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<StudentsData>>
    private val repository: AssistantRepository

    init {
        val studentsDao = AssistantDatabase.getDatabase(application).studentsDao()
        repository = AssistantRepository(studentsDao)
        readAllData = repository.readAllData
    }

    fun addStudent(student: StudentsData){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addStudent(student)
        }
    }

}