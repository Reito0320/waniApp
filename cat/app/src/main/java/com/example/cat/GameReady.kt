package com.example.cat

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameReady : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game_ready)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val startButton: Button = findViewById(R.id.startButton)
        val countView: TextView = findViewById(R.id.countView)

        startButton.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                countView.text = "3"
                delay(1000)

                countView.text = "2"
                delay(1000)

                countView.text = "1"
                delay(1000)

                countView.text = "Go!!"
                delay(500)
                val intent = Intent(this@GameReady, Photo5::class.java)
                startActivity(intent)
            }

        }
    }
}