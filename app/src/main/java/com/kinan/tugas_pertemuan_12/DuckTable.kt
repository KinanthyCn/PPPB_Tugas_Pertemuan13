package com.kinan.tugas_pertemuan_12

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

interface DuckTable {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(duck: Duck)

    @Update
    fun update(duck: Duck)

    @Delete
    fun delete(duck: Duck)

    @get:Query("SELECT * FROM duck_table ORDER BY id ASC")
    val allDucks: LiveData<List<Duck>>

    @Query("SELECT * FROM duck_table WHERE id = :id")
    fun getDuck(id: Int): LiveData<Duck>
}