package com.example.teacherassistant.model.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "courses_table")
data class CoursesData(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val day:String,
    val timeBlock:String
): Parcelable
