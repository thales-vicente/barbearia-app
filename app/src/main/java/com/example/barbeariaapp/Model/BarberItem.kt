package com.example.barbeariaapp.Model

import java.io.Serializable

data class BarberItem(
    val title: String,
    val subtitle: String,
    val horario: String,
    val image: Int
) : Serializable
