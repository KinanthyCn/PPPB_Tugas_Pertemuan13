package com.kinan.tugas_pertemuan_12

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "duck_table")
data class Duck(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Int =0,

    @ColumnInfo(name = "title")
    val title : String,

    @ColumnInfo(name = "description")
    val description : String,

    @ColumnInfo(name = "Message")
    val message : String,

    @ColumnInfo(name = "url")
    val url : String

)
