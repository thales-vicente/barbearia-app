package com.example.barbeariaapp.View

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.barbeariaapp.R
import com.example.barbeariaapp.databinding.ActivityLogInBinding
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogInBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        if (auth.currentUser != null){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        binding.btnEntrar.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){ task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }else{
                        Toast.makeText(this, "Falha no login: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        binding.tvPossuiConta.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        binding.icVoltar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}