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
import com.example.cat.storage.UserDataStore
import kotlinx.coroutines.launch

class qute : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_qute)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val resultView: TextView = findViewById(R.id.resultView)
        val oneMoreButton: Button = findViewById(R.id.oneMoreButton)
        val rankingButton: Button = findViewById(R.id.rankingButton)

        lifecycleScope.launch {
            val userDateStore = UserDataStore(applicationContext)
            val userName = userDateStore.getUserName()
            val response = RetrofitClient.api.login(userName.toString())
            val bestScore = response.bestScore.toString()
            resultView.text = "${userName.toString()}さん ${bestScore}匹(Tap)のワニが\n脱出することに成功しました。"
        }
        oneMoreButton.setOnClickListener {
            val intent = Intent(this@qute, GameReady::class.java)
            startActivity(intent)
        }
        rankingButton.setOnClickListener {
            val intent = Intent(this@qute, RankingPage::class.java)
            startActivity(intent)
        }
    }
}