package com.example.barbeariaapp.View

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.barbeariaapp.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener {
            startActivity(Intent(this, LogInActivity::class.java))
        }

        binding.btnInscrever.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}