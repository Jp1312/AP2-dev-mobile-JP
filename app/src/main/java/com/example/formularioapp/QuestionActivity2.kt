package com.example.formularioapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuestionActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question2)

        // Recebe os dados da QuestionActivity
        val userName = intent.getStringExtra("USER_NAME")
        val answer1 = intent.getStringExtra("ANSWER1")

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {

            val selectedId = radioGroup.checkedRadioButtonId

            if (selectedId != -1) {
                val selectedRadioButton: RadioButton = findViewById(selectedId)
                val selectedOption = selectedRadioButton.text.toString()

                Toast.makeText(this, "Você escolheu: $selectedOption", Toast.LENGTH_SHORT).show()

                // Cria o Intent para a QuestionActivity3
                val intent = Intent(this, QuestionActivity3::class.java)
                // Passa o nome do usuário e as respostas acumuladas para a próxima activity
                intent.putExtra("USER_NAME", userName)
                intent.putExtra("ANSWER1", answer1)
                intent.putExtra("ANSWER2", selectedOption)

                // Inicia a próxima question activity
                startActivity(intent)

            } else {
                Toast.makeText(this, "Por favor, selecione uma opção.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
