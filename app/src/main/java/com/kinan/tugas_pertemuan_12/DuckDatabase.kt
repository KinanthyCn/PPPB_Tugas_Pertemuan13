package com.kinan.tugas_pertemuan_12

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [Duck::class], version = 1, exportSchema = false)
abstract class DuckDatabase : RoomDatabase(){
    abstract fun duckTable(): DuckTable?
    companion object{
        @Volatile
        private var INSTANCE: DuckDatabase? = null
        fun getDatabase(context : Context) : DuckDatabase?{
            if (INSTANCE == null){
                synchronized(DuckDatabase::class.java){
                    INSTANCE = databaseBuilder(
                        context.applicationContext,
                        DuckDatabase::class.java,
                        "duck_database"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}