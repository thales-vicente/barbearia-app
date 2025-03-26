package com.example.barbeariaapp.View

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.barbeariaapp.Adapter.BarberAdapter
import com.example.barbeariaapp.ViewModel.MainViewModel
import com.example.barbeariaapp.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        FirebaseApp.initializeApp(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvReserve.setOnClickListener {
            startActivity(Intent(this, ServicoActivity::class.java))
        }

        binding.ivVoltar.setOnClickListener {
            finish()
        }
        setupRecyclerView()
        observeViewModel()
    }
    private fun setupRecyclerView(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        binding.recyclerView.setHasFixedSize(true)
    }
    private fun observeViewModel(){
        viewModel.barberItems.observe(this) { items ->
            binding.recyclerView.adapter = BarberAdapter(items){clickedItem ->
                val intent = Intent(this, ServicoActivity::class.java).apply {
                    putExtra("BARBER_ITEM", clickedItem)
                }
                startActivity(intent)
            }
        }
    }
}