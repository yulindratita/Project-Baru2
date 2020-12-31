package com.titacolls.app.data.remote

import com.titacolls.app.data.model.Komunitas
import com.titacolls.app.data.model.KomunitasList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface KomunitasService {
    @GET("/")
    fun listKomunitas() : Call<KomunitasList>

    @GET("detail/")
    fun detailKomunitas(@Query("url") url: String) : Call<KomunitasList>

    @GET("search/")
    fun searchKomunitas(@Query("q") query: String) : Call<KomunitasList>

}