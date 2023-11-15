package com.kinan.tugas_pertemuan_12.model

import com.google.gson.annotations.SerializedName

data class Bebek(
    @SerializedName("message")
    val message: String,

    @SerializedName("url")
    val imgUrl: String
)
