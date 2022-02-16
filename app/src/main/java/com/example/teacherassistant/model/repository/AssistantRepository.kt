package com.example.teacherassistant.model.repository

import androidx.lifecycle.LiveData
import com.example.teacherassistant.model.dao.StudentsDao
import com.example.teacherassistant.model.entities.StudentsData

class AssistantRepository(private val studentsDao: StudentsDao) {

    val readAllData: LiveData<List<StudentsData>> = studentsDao.readAllData()

    suspend fun addStudent(student: StudentsData){
        studentsDao.addStudent(student)
    }

}