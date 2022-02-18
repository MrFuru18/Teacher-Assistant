package com.example.teacherassistant.model.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "grades_table")
data class GradesData(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val idCourse:Int,
    val idStudent:Int,
    val grade: Double,
    val category: String,
    val comm: String
):Parcelable
