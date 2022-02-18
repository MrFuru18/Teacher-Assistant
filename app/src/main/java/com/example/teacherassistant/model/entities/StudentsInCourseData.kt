package com.example.teacherassistant.model.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "studentsInCourse_table")
data class StudentsInCourseData(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val idCourse:Int,
    val name:String,
    val day:String,
    val timeBlock:String,
    val idStudent:Int,
    val firstName:String,
    val lastName:String
):Parcelable
