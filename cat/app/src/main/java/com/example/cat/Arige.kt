package com.example.cat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.cat.network.RetrofitClient
import com.example.cat.storage.UserDataStore
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class Arige : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_arige)

        val input: EditText = findViewById(R.id.userInput)
        val button: Button = findViewById(R.id.button)
        val blueBox: TextView = findViewById(R.id.blueBox)

        lifecycleScope.launch {
            try {
                val userDateStore = UserDataStore(applicationContext)
                val userName = userDateStore.getUserName()
                if (userName != null) {
                    val response = RetrofitClient.api.login(userName)
                    input.setText(response.currentScore.toString())
                    delay(1000)
                    button.performClick()
                    delay(1000)
                    val intent = Intent(this@Arige, RunArige::class.java)
                    startActivity(intent)
                }
            } catch (error: Exception) {
                println(error.message)
            }
        }
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