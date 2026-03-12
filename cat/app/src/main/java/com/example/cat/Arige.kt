package com.example.cat

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
class Arige : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_arige)

        val input: EditText = findViewById(R.id.userInput)
        val button: Button = findViewById(R.id.button)
        val blueBox: TextView = findViewById(R.id.blueBox)

        var result: String = ""
        button.setOnClickListener {
            val userInput = input.text.toString()
            if (userInput.isNotEmpty()) {
                for (i in 0 until userInput.toInt()) {
                    result += "🐊"
                }
                blueBox.setBackgroundColor(android.graphics.Color.parseColor("#311F6F"))
                blueBox.text = result
            }
        }

    }
}