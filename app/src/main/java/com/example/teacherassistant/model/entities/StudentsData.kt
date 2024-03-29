package com.example.teacherassistant.model.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "students_table")
data class StudentsData(
    @PrimaryKey(autoGenerate = false)
    val id:Int,
    val firstName:String,
    val lastName:String
):Parcelable
