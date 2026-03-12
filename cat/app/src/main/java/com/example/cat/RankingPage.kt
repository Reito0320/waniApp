package com.example.cat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.cat.network.RetrofitClient
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class RankingPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ranking_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val rankingView: TextView = findViewById(R.id.rankingView)
        val backButton: Button = findViewById(R.id.backButton)

        backButton.setOnClickListener {
            val intent = Intent(this@RankingPage, qute::class.java)
            startActivity(intent)
        }

        lifecycleScope.launch {
            val allData = RetrofitClient.api.users()
            val filterList = allData.filter { it.bestScore != 0 }
            val sortData = filterList.sortedByDescending { it.bestScore }
            // formatをするためのもを作る。
            val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")

            println(sortData[0].bestScoreDateTime)
            val rankingText = sortData.joinToString("\n") {
                val dateTime = LocalDateTime.parse(it.bestScoreDateTime)
                    "${dateTime.format(formatter)}\nName:${it.name} BestScore:${it.bestScore}\n"
            }
            rankingView.text = rankingText
        }
    }
}