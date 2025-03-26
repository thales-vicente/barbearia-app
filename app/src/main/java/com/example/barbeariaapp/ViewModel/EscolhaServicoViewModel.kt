package com.example.barbeariaapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.barbeariaapp.Model.BarberItem
import com.example.barbeariaapp.Repository.EscolhaServicoRepository

class EscolhaServicoViewModel: ViewModel() {
    private val repository = EscolhaServicoRepository()
    private val _barberItems = MutableLiveData<List<BarberItem>>()
    val barberItems: LiveData<List<BarberItem>> get() = _barberItems

    init {
        loadBarberItems()
    }
    private fun loadBarberItems(){
        _barberItems.value = repository.getBarberItems()
    }
}