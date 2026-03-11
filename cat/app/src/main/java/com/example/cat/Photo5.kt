package com.example.cat

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Photo5 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_photo5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val countView: TextView = findViewById(R.id.count)
        val targetImg: ImageView = findViewById(R.id.targetImage)
        val timer: TextView = findViewById(R.id.timer)

        CoroutineScope(Dispatchers.Main).launch {
            for (i in 1..30) {
                delay(1000)
                timer.text = "残り時間: ${i.toString()}"
                if (i == 30) {
                    val intent= Intent(this@Photo5, Photo4::class.java)
                    startActivity(intent)
                }
            }
        }

        var count = 0;
        targetImg.setOnClickListener {
            count++
            countView.text = count.toString()
        }
    }
}