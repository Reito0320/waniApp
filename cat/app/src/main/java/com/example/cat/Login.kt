package com.example.cat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.cat.network.RetrofitClient
import kotlinx.coroutines.launch
import com.example.cat.storage.UserDataStore

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val userName: EditText = findViewById(R.id.userName)
        val login: Button = findViewById(R.id.login)

        login.setOnClickListener {
            val name = userName.text.toString()

            when(name) {
                "" -> userName.error = "名前を入力してください。"
            }

//            これでcleanupしてくれる。 非同期処理をこの中でしますよ。
            lifecycleScope.launch {
                try {
                    val response = RetrofitClient.api.login(name)

                    // localstorage的なものに保存
                    val userDataStore = UserDataStore(applicationContext)
                    userDataStore.saveUser(response.id, response.name)

                    // ページ遷移用のコード
                    val intent = Intent(this@Login, GameReady::class.java)
                    startActivity(intent)
                } catch (error: Exception) {
                    userName.error = error.message
                }
            }
        }
    }
}