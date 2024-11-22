package com.example.formularioapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        // Recebe o nome do usuário da MainActivity
        val userName = intent.getStringExtra("USER_NAME")

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {

            // Verifica qual opção foi selecionada
            val selectedId = radioGroup.checkedRadioButtonId

            if (selectedId != -1) {
                val selectedRadioButton: RadioButton = findViewById(selectedId)
                val selectedOption = selectedRadioButton.text.toString()

                // Exibe uma mensagem de confirmação com a opção escolhida
                Toast.makeText(this, "Você escolheu: $selectedOption", Toast.LENGTH_SHORT).show()

                // Cria o Intent para a QuestionActivity2
                val intent = Intent(this, QuestionActivity2::class.java)
                // Passa o nome do usuário e a resposta atual para a próxima activity
                intent.putExtra("USER_NAME", userName)
                intent.putExtra("ANSWER1", selectedOption)

                // Inicia a próxima question activity
                startActivity(intent)

            } else {
                Toast.makeText(this, "Por favor, selecione uma opção.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
