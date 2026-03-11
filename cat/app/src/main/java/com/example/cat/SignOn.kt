package com.example.cat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.cat.network.request.SignOnRequest
import com.example.cat.network.RetrofitClient
import com.example.cat.storage.UserDataStore
import kotlinx.coroutines.launch

class SignOn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_on)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val userName: EditText = findViewById(R.id.userName)
        val signOn: Button = findViewById(R.id.signOn)

        signOn.setOnClickListener {
            val name = userName.text.toString()

            when(name) {
                "" -> userName.error = "名前を入力してください。"
            }

//            これでcleanupしてくれる。 非同期処理をこの中でしますよ。
            lifecycleScope.launch {
                try {
                    val response = RetrofitClient.api.signOn(name)

//                    applicationContextはそもそもdataStoreで必要な引数。
//                    元々存在しているもの。このファイルでapplicationContextを書けば、
//                    このファイルのapp全体のデータがわたる。ここはもはやおまじない。
                    val userDataStore = UserDataStore(applicationContext)
                    userDataStore.saveUser(response.id, response.name)

                    // ページ遷移用のコード
                    val intent = Intent(this@SignOn, Photo1::class.java)
                    startActivity(intent)
                } catch (error: Exception) {
                    userName.error = error.message
                }
            }
        }
    }
}