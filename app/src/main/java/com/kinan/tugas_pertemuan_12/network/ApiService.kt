package com.kinan.tugas_pertemuan_12.network

import com.kinan.tugas_pertemuan_12.model.Bebek
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("random")
    fun getRandomDuck() : Call<Bebek>

}
