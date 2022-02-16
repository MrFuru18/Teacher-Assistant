package com.example.teacherassistant.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students_table")
data class StudentsData(
    @PrimaryKey(autoGenerate = false)
    val id:Int,
    val firstName:String,
    val lastName:String
)
