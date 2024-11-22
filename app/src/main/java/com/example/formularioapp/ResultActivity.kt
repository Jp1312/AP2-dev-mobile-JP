package com.example.formularioapp

import android.util.Log
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Receber dados passados das Activities anteriores
        val nomeUsuario = intent.getStringExtra("nomeUsuario")
        val resposta1 = intent.getStringExtra("resposta1") // Resposta da primeira pergunta
        val resposta2 = intent.getStringExtra("resposta2") // Resposta da segunda pergunta
        val resposta3 = intent.getStringExtra("resposta3") // Resposta da terceira pergunta
        val resposta4 = intent.getStringExtra("resposta4") // Resposta da quarta pergunta


        val perfil = determinarPerfilInvestidor(resposta1, resposta2, resposta3, resposta4)


        val resultTextView: TextView = findViewById(R.id.resultTextView)
        resultTextView.text = """
            Nome: $nomeUsuario
            Perfil do Investidor: $perfil
        """.trimIndent()
    }


    private fun determinarPerfilInvestidor(
        resposta1: String?,
        resposta2: String?,
        resposta3: String?,
        resposta4: String?
    ): String {
        Log.d("ResultActivity", "Resposta 1: $resposta1")
        Log.d("ResultActivity", "Resposta 2: $resposta2")
        Log.d("ResultActivity", "Resposta 3: $resposta3")
        Log.d("ResultActivity", "Resposta 4: $resposta4")

        // Verificar se todas as respostas começam com "A"
        return when {

            // Todas as respostas começam com "A" - Conservador
            resposta1?.startsWith("A") == true &&
                    resposta2?.startsWith("A") == true &&
                    resposta3?.startsWith("A") == true &&
                    resposta4?.startsWith("A") == true -> {
                "Conservador"
            }

            // Se alguma resposta começar com "C", então "Arrojado"
            resposta1?.startsWith("C") == true ||
                    resposta2?.startsWith("C") == true ||
                    resposta3?.startsWith("C") == true ||
                    resposta4?.startsWith("C") == true -> {
                "Arrojado"
            }

            // Se não for "A" nem "C", então "Moderado"
            else -> "Moderado"
        }
    }
}