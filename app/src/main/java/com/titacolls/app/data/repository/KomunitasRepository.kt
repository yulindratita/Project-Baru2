package com.titacolls.app.data.repository

import com.titacolls.app.data.model.ActionState
import com.titacolls.app.data.model.Komunitas
import com.titacolls.app.data.remote.KomunitasService
import com.titacolls.app.data.remote.RetrofitApi
import retrofit2.await
import retrofit2.http.Query
import java.lang.Exception

class KomunitasRepository {
    private val komunitasService: KomunitasService by lazy { RetrofitApi.komunitasService() }

    suspend fun listKomunitas() : ActionState<List<Komunitas>> {
        return try {
            val list = komunitasService.listKomunitas().await()
            ActionState(list.data)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailKomunitas(url: String) : ActionState<Komunitas> {
        return try {
            val list = komunitasService.detailKomunitas(url).await()
            ActionState(list.data.first())
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
            }
        }

    suspend fun searchKomunitas(query: String) : ActionState<List<Komunitas>> {
        return try {
            val list = komunitasService.searchKomunitas(query).await()
            ActionState(list.data)
        } catch (e: Exception) {
        ActionState(message = e.message, isSuccess = false)
        }
    }

    }
