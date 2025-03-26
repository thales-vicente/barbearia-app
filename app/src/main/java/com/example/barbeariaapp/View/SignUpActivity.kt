package com.example.barbeariaapp.View

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.barbeariaapp.R
import com.example.barbeariaapp.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.icVoltar.setOnClickListener {
            finish()
        }
        auth = FirebaseAuth.getInstance()

        binding.btnInscrever.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this){ task ->
                    if (task.isSuccessful){
                        val user = auth.currentUser
                        Toast.makeText(this@SignUpActivity, "Cadastro realizado com sucesso! Bem-vindo: ${user?.email}",
                            Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@SignUpActivity, MainActivity::class.java))
                        finish()
                    }else{
                        Toast.makeText(this@SignUpActivity, "Falha no cadastro: ${task.exception?.message}",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}