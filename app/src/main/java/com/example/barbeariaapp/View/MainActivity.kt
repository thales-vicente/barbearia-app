package com.example.barbeariaapp.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.barbeariaapp.R
import com.example.barbeariaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}