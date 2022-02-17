package com.example.teacherassistant.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.teacherassistant.model.dao.CoursesDao
import com.example.teacherassistant.model.dao.StudentsDao
import com.example.teacherassistant.model.entities.CoursesData
import com.example.teacherassistant.model.entities.StudentsData

@Database(entities = [StudentsData::class, CoursesData::class], version = 1, exportSchema = false)
abstract class AssistantDatabase:RoomDatabase() {

    abstract fun studentsDao(): StudentsDao
    abstract fun coursesDao(): CoursesDao

    companion object{
        @Volatile
        private var INSTANCE: AssistantDatabase? = null

        fun getDatabase(context: Context): AssistantDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AssistantDatabase::class.java,
                    "assistant_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}