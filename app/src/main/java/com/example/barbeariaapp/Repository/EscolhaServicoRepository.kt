package com.example.barbeariaapp.Repository

import com.example.barbeariaapp.Model.BarberItem
import com.example.barbeariaapp.R

class EscolhaServicoRepository {
    fun getBarberItems(): List<BarberItem>{
        return listOf(
            BarberItem("CLUBE DE CAVALHEIROS", "Horário disponível", "10am - 10pm", R.drawable.img_background03),
            BarberItem("CLUBE DE CAVALHEIROS", "Horário disponível", "10am - 10pm", R.drawable.img_background),
            BarberItem("CLUBE DE CAVALHEIROS", "Horário disponível", "10am - 10pm", R.drawable.img_background03),
            BarberItem("CLUBE DE CAVALHEIROS", "Horário disponível", "10am - 10pm", R.drawable.img_background03)
        )
    }
}