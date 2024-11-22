package com.example.formularioapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuestionActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question3)

        // Receber dados das perguntas anteriores
        val nomeUsuario = intent.getStringExtra("USER_NAME") // Usando a chave correta aqui
        val resposta1 = intent.getStringExtra("ANSWER1")
        val resposta2 = intent.getStringExtra("ANSWER2")

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val radioA: RadioButton = findViewById(R.id.radioA)
        val radioB: RadioButton = findViewById(R.id.radioB)
        val radioC: RadioButton = findViewById(R.id.radioC)
        val radioD: RadioButton = findViewById(R.id.radioD)

        val btnSubmit: Button = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            // Determina qual resposta foi selecionada
            val resposta3 = when {
                radioA.isChecked -> "A: Não possuo formação acadêmica ou conhecimento do mercado financeiro"
                radioB.isChecked -> "B: Possuo formação acadêmica na área financeira, mas não tenho experiência com o mercado financeiro"
                radioC.isChecked -> "C: Possuo formação acadêmica em outra área, mas possuo conhecimento do mercado financeiro"
                radioD.isChecked -> "D: Possuo formação acadêmica na área financeira ou pleno conhecimento do mercado financeiro"
                else -> null
            }

            if (resposta3 != null) {
                // Passa os dados acumulados para a próxima Activity (QuestionActivity4)
                val intent = Intent(this, QuestionActivity4::class.java)
                intent.putExtra("nomeUsuario", nomeUsuario)
                intent.putExtra("resposta1", resposta1)
                intent.putExtra("resposta2", resposta2)
                intent.putExtra("resposta3", resposta3)
                startActivity(intent)
            } else {
                // Exibe mensagem caso nenhuma opção seja selecionada
                Toast.makeText(this, "Por favor, selecione uma opção.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
