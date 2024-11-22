package com.example.formularioapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuestionActivity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question4)

        // Receber os dados acumulados das perguntas anteriores
        val nomeUsuario = intent.getStringExtra("nomeUsuario")
        val resposta1 = intent.getStringExtra("resposta1")
        val resposta2 = intent.getStringExtra("resposta2")
        val resposta3 = intent.getStringExtra("resposta3")

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val radioA: RadioButton = findViewById(R.id.radioA)
        val radioB: RadioButton = findViewById(R.id.radioB)
        val radioC: RadioButton = findViewById(R.id.radioC)

        val btnSubmit: Button = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            // Determina qual resposta foi selecionada
            val resposta4 = when {
                radioA.isChecked -> "A: No máximo 25%"
                radioB.isChecked -> "B: Entre 25,01 e 50%"
                radioC.isChecked -> "C: Acima de 50%"
                else -> null
            }

            if (resposta4 != null) {
                // Passar todos os dados acumulados para a ResultActivity
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("nomeUsuario", nomeUsuario)
                intent.putExtra("resposta1", resposta1)
                intent.putExtra("resposta2", resposta2)
                intent.putExtra("resposta3", resposta3)
                intent.putExtra("resposta4", resposta4)
                startActivity(intent)
            } else {
                // Exibe mensagem caso nenhuma opção seja selecionada
                Toast.makeText(this, "Por favor, selecione uma opção.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
