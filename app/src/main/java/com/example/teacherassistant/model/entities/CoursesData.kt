package com.example.teacherassistant.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "courses_table")
data class CoursesData(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val day:String,
    val timeBlock:String
)
