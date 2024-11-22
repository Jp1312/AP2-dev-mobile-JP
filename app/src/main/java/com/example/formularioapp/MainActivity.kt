package com.example.formularioapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referência para os elementos de UI
        val edtName: EditText = findViewById(R.id.edtName)
        val btnStart: Button = findViewById(R.id.btnStart)

        // Configura o botão de início
        btnStart.setOnClickListener {
            val userName = edtName.text.toString()

            // Verifica se o nome não está vazio
            if (userName.isNotEmpty()) {

                // Debug: Mostra o nome digitado
                Toast.makeText(this, "Nome passado: $userName", Toast.LENGTH_SHORT).show()

                // Cria a Intent para a próxima Activity
                val intent = Intent(this, QuestionActivity::class.java)

                // Passa o nome do usuário para a próxima Activity
                intent.putExtra("USER_NAME", userName)

                // Inicia a próxima Activity
                startActivity(intent)
            } else {
                // Exibe um aviso caso o nome esteja vazio
                Toast.makeText(this, "Por favor, digite seu nome.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
