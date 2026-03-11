package com.example.cat

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import com.example.cat.network.RetrofitClient
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        lifecycleScope.launch {
            try {
                val user = RetrofitClient.api.getUser(1)
                Log.d("API_TEST", "name = ${user.name}")
            } catch (e: Exception) {
                Log.e("API_TEST", "error", e)
            }
        }
    }
}