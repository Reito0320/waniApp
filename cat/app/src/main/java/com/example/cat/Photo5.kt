package com.example.cat

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.cat.network.RetrofitClient
import com.example.cat.network.request.GameRequest
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.example.cat.storage.UserDataStore
import java.time.LocalDateTime

class Photo5 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
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

        var count = 0
        targetImg.setOnClickListener {
            count++
            countView.text = count.toString()
        }

        lifecycleScope.launch {
            for (i in 30 downTo 0) {
                delay(1000)
                timer.text = "残り時間: ${i.toString()}"
                if (i == 0) {
                    // このタイミングでデータをinsertしたい。
                    try {
                        val userDateStore = UserDataStore(applicationContext)
                        val userId = userDateStore.getUserId()
                            if (userId != null) {
                                val body = GameRequest (
                                    bestScore = count,
                                    bestScoreDateTime = LocalDateTime.now().toString(),
                                )
                                val response = RetrofitClient.api.scorePatch(userId.toLong(),body)
                            }
                    } catch (error: Exception) {
                        countView.error = error.message
                    }
                    val intent= Intent(this@Photo5, Arige::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}