package com.titacolls.app.ui.komunitas

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.titacolls.app.data.model.ActionState
import com.titacolls.app.data.model.Komunitas
import com.titacolls.app.data.repository.KomunitasRepository
import kotlinx.coroutines.launch
import retrofit2.http.Query

class KomunitasViewModel : ViewModel() {
    private val repo: KomunitasRepository by lazy { KomunitasRepository() }

    val loading = MutableLiveData(false)
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<Komunitas>>()
    val detailResp = MutableLiveData<Komunitas>()
    val searchResp = MutableLiveData<List<Komunitas>>()

    val url = MutableLiveData("")
    val query = MutableLiveData("")

    fun listKomunitas() {
        viewModelScope.launch {
            loading.value = true
            val resp = repo.listKomunitas()
            actionState.value = resp
            listResp.value = resp.data
            loading.value = false
        }
    }

    fun detailKomunitas(url: String? = this.url.value) {
        url?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.detailKomunitas(it)
                actionState.value = resp
                detailResp.value = resp.data
                loading.value = false
            }
        }
    }


    fun searchKomunitas(query: String? = this.query.value) {
        query?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.searchKomunitas(it)
                actionState.value = resp
                searchResp.value = resp.data
                loading.value = false
            }
        }
    }
}