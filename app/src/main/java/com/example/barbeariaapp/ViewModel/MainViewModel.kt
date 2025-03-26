package com.example.barbeariaapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.barbeariaapp.Model.BarberItem
import com.example.barbeariaapp.Repository.BarberRepository

class MainViewModel : ViewModel() {
    private val _barberItems = MutableLiveData<List<BarberItem>>()
    val barberItems: LiveData<List<BarberItem>> get() = _barberItems

    init {
        loadBarberItems()
    }
    private fun loadBarberItems(){
        val repository = BarberRepository()
        _barberItems.value = repository.getBarberItems()
    }
}