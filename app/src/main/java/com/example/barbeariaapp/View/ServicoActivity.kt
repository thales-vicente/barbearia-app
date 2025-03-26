package com.example.barbeariaapp.View

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.barbeariaapp.R
import com.example.barbeariaapp.ViewModel.EscolhaServicoViewModel
import com.example.barbeariaapp.databinding.ActivityServicoBinding

class ServicoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityServicoBinding
    private val viewModel: EscolhaServicoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServicoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivVoltar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        viewModel.barberItems.observe(this) { items ->
            if (items.isEmpty()){
                val barberItem = items[0]
                binding.tvBemVindo.text = "Bem-vindo ao ${barberItem.title}"
                binding.tvClube.text = barberItem.title
                binding.tvDescicao.text = barberItem.subtitle
                binding.tvAberto.text = barberItem.horario
            }
        }
        binding.rgServicos.setOnCheckedChangeListener { _, checkedID->
            when(checkedID){
                R.id.rbtn_cabelo ->{
                    println("Serviço selecionado: Corte de Cabelo")
                }
                R.id.rbtn_barba ->{
                    println("Serviço selecionado: Barba")
                }
                R.id.rbtn_senior ->{
                    println("Serviço selecionado: Corte Senior")
                }
                R.id.rbtn_tesoura ->{
                    println("Serviço selecionado: Corte de Tesoura")
                }
                R.id.rbtn_infantil ->{
                    println("Serviço selecionado: Corte Infantil")
                }
            }
        }
        binding.btnReserve.setOnClickListener {
            val selectedService = when( binding.rgServicos.checkedRadioButtonId){
                R.id.rbtn_cabelo -> "Corte de cabelo"
                R.id.rbtn_barba -> "Barba"
                R.id.rbtn_senior -> "Corte Senior"
                R.id.rbtn_tesoura -> "Corte de Tesoura"
                R.id.rbtn_infantil -> "Corte Infantil"
                else -> null
            }
            val selectedTime = binding.spinner.selectedItem.toString()
            if (selectedService != null && selectedTime.isNotEmpty()){
                Toast.makeText(this, "Reserva confirmada: $selectedService às $selectedTime", Toast.LENGTH_LONG).show()

                println("Reserva confirmada: $selectedService às $selectedTime")
            }else{
                Toast.makeText(this, "Erro: Serviço ou horário não selecionado!", Toast.LENGTH_LONG).show()
            }
        }
    }
}